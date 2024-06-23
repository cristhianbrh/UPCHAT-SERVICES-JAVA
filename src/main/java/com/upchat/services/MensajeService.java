package com.upchat.services;

import java.util.List;

import com.upchat.model.Mensaje;
import com.upchat.model.StarCalification;

public class MensajeService implements IMensajeService {

	@Override
	public Mensaje CrearMensaje(Mensaje mensaje) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mensaje> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mensaje> findPublishersAll(String jwt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mensaje> findResponsesInMessage(String jwt, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mensaje> getPublications(String jwt, int isPublication, int messageIdOne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StarCalification updateStar(int idMessage, String jwt, int number) {
		// TODO Auto-generated method stub
		return null;
	}

}
