package com.upchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upchat.dtos.usersAddDto;
import com.upchat.model.Usuario;
import com.upchat.services.IUsuarioService;

@Controller
@RequestMapping(value="users")
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@PostMapping("/add")
	public ResponseEntity<String> AddUser(@RequestBody usersAddDto usuario) {
		
		return usuarioService.AddUsuario(usuario);
	}
}
