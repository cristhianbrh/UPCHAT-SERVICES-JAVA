package com.upchat.services;

import java.util.List;

import com.upchat.model.Categoria;

public interface ICategoriaService {
	public List<Categoria> FindAll();
	public Categoria addCategoria(Categoria newCategory);
}
