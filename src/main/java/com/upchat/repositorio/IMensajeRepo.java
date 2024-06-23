package com.upchat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upchat.model.Mensaje;



@Repository
public interface IMensajeRepo extends JpaRepository<Mensaje, Integer> {

}
