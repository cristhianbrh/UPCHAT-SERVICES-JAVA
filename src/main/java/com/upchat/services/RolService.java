package com.upchat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upchat.model.Categoria;
import com.upchat.model.Rol;
import com.upchat.repositorio.IRolRepo;

@Service
public class RolService implements IRolService {

	@Autowired
	IRolRepo rolRepo;

	@Override
	public List<Rol> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol getRolById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol createRol(Rol rol) {
		Rol rolIfExist = rolRepo.findByDescripcion(rol.getDescripcion());

		if (rolIfExist != null) {
			return null; 
		}

		// TODO Auto-generated method stub
		return rolRepo.save(rol);
	}

}
