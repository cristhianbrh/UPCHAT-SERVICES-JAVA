package com.upchat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upchat.model.StarCalification;

@Repository
public interface IStarCalification extends JpaRepository<StarCalification, Integer> {

}
