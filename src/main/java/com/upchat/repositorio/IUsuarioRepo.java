package com.upchat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upchat.model.Usuario;


@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>  {

}
