package com.upchat.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.upchat.dtos.categoryGetAllDto;
import com.upchat.model.Categoria;

public interface ICategoriaService {
	public ResponseEntity<List<categoryGetAllDto>> FindAll();
	public Categoria addCategoria(Categoria newCategory);
}
