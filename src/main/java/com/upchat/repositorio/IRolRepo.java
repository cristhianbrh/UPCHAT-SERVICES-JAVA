package com.upchat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upchat.model.Rol;


@Repository
public interface IRolRepo extends JpaRepository<Rol, Integer> {
    Rol findByDescripcion(String descripcion);
}
