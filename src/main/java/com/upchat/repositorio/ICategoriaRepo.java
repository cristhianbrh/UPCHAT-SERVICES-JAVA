package com.upchat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upchat.model.Categoria;

@Repository
public interface ICategoriaRepo extends JpaRepository<Categoria , Integer> {
	
}
