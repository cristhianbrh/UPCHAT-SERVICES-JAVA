package com.upchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upchat.dtos.messageCreateNewDto;
import com.upchat.services.IMensajeService;

@Controller
@RequestMapping(value = "message")
public class MensajeController {
    // @GetMapping("/all")
    // public void allPublications() {
    // }

    @Autowired
    IMensajeService mensajeService;

    @PostMapping("/newPost")
    public ResponseEntity<String> createNewPost(
            @RequestParam(name = "jwt") String jwt,
            @RequestBody messageCreateNewDto newMessage) {
        return mensajeService.CrearMensaje(newMessage, jwt, "newPost");
    }
    @PostMapping("/newResponse")
    public ResponseEntity<String> createNewResponse(
            @RequestParam(name = "jwt") String jwt,
            @RequestBody messageCreateNewDto newMessage) {
        return mensajeService.CrearMensaje(newMessage, jwt, "newResponse");
    }
}
