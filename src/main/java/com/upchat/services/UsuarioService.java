package com.upchat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upchat.dtos.usersAddDto;
import com.upchat.model.Rol;
import com.upchat.model.Usuario;
import com.upchat.repositorio.IRolRepo;
import com.upchat.repositorio.IUsuarioRepo;
import com.upchat.utils.JwtUtil;
import com.upchat.utils.PasswordUtil;

import io.jsonwebtoken.Jwts;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	IUsuarioRepo usuarioRepo;

	@Autowired
	IRolRepo rolRepo;

	@Autowired
	PasswordUtil passwordUtil;

	@Autowired
	JwtUtil jwtUtil;

	@Override
	public ResponseEntity<String> AddUsuario(usersAddDto newUsuario) {
		System.out.println(newUsuario);

		// Rol rol = rolRepo.findById(302).get();
		Rol rol = rolRepo.findByDescripcion("usuario");
		System.out.println(rol);

		Usuario usuario = new Usuario();
		usuario.setNombre(newUsuario.nombre);
		usuario.setCorreo(newUsuario.correo);
		usuario.setTelefono(newUsuario.telefono);
		usuario.setEsActivo(true);
		usuario.setClave(passwordUtil.hashPassword(newUsuario.clave));
		usuario.setRol(rol);
		System.out.println(newUsuario);

		Usuario ifUserExist = usuarioRepo.findByCorreo(newUsuario.correo);
		if (ifUserExist != null) {
			return new ResponseEntity<>("El correo ya existe", HttpStatus.NOT_FOUND);
		}

		usuarioRepo.save(usuario);

		String userJwt = jwtUtil.JwtGenerateUser(usuario);
		// String jwt = Jwts.builder()
		// .setSubject(usuario);

		return new ResponseEntity<>(userJwt, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> LoginUser(String user, String password) {

		Usuario usuario = usuarioRepo.findByCorreo(user);
		if (usuario == null) {
			return new ResponseEntity<>("Usuario no existe", HttpStatus.NOT_FOUND);
		}
		if (!passwordUtil.verifyPassword(password, usuario.getClave())) {
			return new ResponseEntity<>("La contraseña no es correcta", HttpStatus.NOT_FOUND);
		}

		System.out.println(usuario);
		return new ResponseEntity<>(jwtUtil.JwtGenerateUser(usuario), HttpStatus.OK);
	}

	@Override
	public Usuario getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> AuthUserByJwt(String jwt) {

		boolean isValid = jwtUtil.isJwtValid(jwt);
		if (!isValid) {
			return new ResponseEntity<>("El token no es incorrecto", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(jwt, HttpStatus.OK);
	}

}
