package com.upchat.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upchat.dtos.categoryGetAllDto;
import com.upchat.model.Categoria;
import com.upchat.repositorio.ICategoriaRepo;
@Service
public class CategoriaService implements ICategoriaService {
	@Autowired
	ICategoriaRepo categoriaRepo;

	@Override
	public Categoria addCategoria(Categoria newCategory) {
		
		return categoriaRepo.save(newCategory);
	}

	@Override
	public ResponseEntity<List<categoryGetAllDto>> FindAll() {
		
		List<Categoria> categories = categoriaRepo.findAll();
		List<categoryGetAllDto> categoriesConvert = categories.stream()
				.map(category -> new categoryGetAllDto(category.getIdCategoria(), category.getDescripcion()))
				.collect(Collectors.toList()); 
				
		return new ResponseEntity<>(categoriesConvert, HttpStatus.OK);
	}

}
