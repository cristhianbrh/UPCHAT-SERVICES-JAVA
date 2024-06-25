package com.upchat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upchat.dtos.categoryGetAllDto;
import com.upchat.model.Categoria;
import com.upchat.services.ICategoriaService;

@Controller
@RequestMapping(value = "category")
public class CategoriaController {

	@Autowired
	ICategoriaService categoriaService;

	@GetMapping("/all")
	public ResponseEntity<List<categoryGetAllDto>> getAllCategory() {
		return categoriaService.FindAll();
	}
}
