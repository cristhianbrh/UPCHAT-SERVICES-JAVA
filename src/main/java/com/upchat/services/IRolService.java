package com.upchat.services;

import java.util.List;

import com.upchat.model.Rol;

public interface IRolService {
	public List<Rol> getAllRoles();
	public Rol getRolById(int id);
	public Rol createRol(Rol rol);
}
