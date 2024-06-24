package com.upchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upchat.services.IUsuarioService;

@Controller
@RequestMapping(value = "auth")
public class AuthController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/user")
    public ResponseEntity<String> authUserByToken(@RequestParam(name="jwt") String jwt) {
        return usuarioService.AuthUserByJwt(jwt);
    }
}
