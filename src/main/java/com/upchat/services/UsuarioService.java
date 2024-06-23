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
import com.upchat.utils.PasswordUtil;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	IUsuarioRepo usuarioRepo;
	
	@Autowired 
	IRolRepo rolRepo;

	@Autowired
	PasswordUtil passwordUtil;

	@Override
	public ResponseEntity<String> AddUsuario(usersAddDto newUsuario) {
		System.out.println(newUsuario);
		
		Rol rol = rolRepo.findById(252).get();
		System.out.println(rol);
		
		Usuario usuario = new Usuario();
		usuario.setNombre(newUsuario.nombre);
		usuario.setCorreo(newUsuario.correo);
		usuario.setTelefono(newUsuario.telefono);
		usuario.setEsActivo(true);
		usuario.setClave(passwordUtil.hashPassword(newUsuario.clave));
		usuario.setRol(rol);
		System.out.println(newUsuario);

		
		usuarioRepo.save(usuario);
		
		return new ResponseEntity<>("Genial sèha insertado correctamente", HttpStatus.OK);
	}

	@Override
	public String LoginUser(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
