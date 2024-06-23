package com.upchat.services;

import com.upchat.model.Mensaje;
import com.upchat.model.StarCalification;
import com.upchat.model.Usuario;

public interface IStarService {
	
	public StarCalification insertStar(Usuario usuario, Mensaje mensaje, int star);
}
