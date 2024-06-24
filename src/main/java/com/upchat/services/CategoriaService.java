package com.upchat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Categoria> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
