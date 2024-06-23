package com.upchat.services;

import java.util.List;

import com.upchat.model.Mensaje;
import com.upchat.model.StarCalification;

public interface IMensajeService {
	public Mensaje CrearMensaje(Mensaje mensaje);

	public List<Mensaje> findAll();

	public List<Mensaje> findPublishersAll(String jwt);

	public List<Mensaje> findResponsesInMessage(String jwt, int number);

	public List<Mensaje> getPublications(String jwt, int isPublication, int messageIdOne);

	public StarCalification updateStar(int idMessage, String jwt, int number);
}
