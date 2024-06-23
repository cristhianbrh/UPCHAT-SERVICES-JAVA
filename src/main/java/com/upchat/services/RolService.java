package com.upchat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		rolRepo.save(rol);
		// TODO Auto-generated method stub
		return null;
	}

}
