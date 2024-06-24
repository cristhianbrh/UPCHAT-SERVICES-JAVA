package com.upchat.services;

import org.springframework.http.ResponseEntity;

import com.upchat.dtos.usersAddDto;
import com.upchat.model.Usuario;

public interface IUsuarioService {
	public ResponseEntity<String> AddUsuario(usersAddDto usuario);

	public  ResponseEntity<String> LoginUser(String user, String password);

	public Usuario getUserById(int id);

	public ResponseEntity<String> AuthUserByJwt(String jwt);
}
