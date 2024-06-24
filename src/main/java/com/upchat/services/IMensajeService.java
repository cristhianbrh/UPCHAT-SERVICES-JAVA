package com.upchat.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.upchat.dtos.messageCreateNewDto;
import com.upchat.dtos.messageGetAllInfoQuery;
import com.upchat.model.Mensaje;
import com.upchat.model.StarCalification;

public interface IMensajeService {
	public ResponseEntity<String> CrearMensaje(messageCreateNewDto mensaje, String jwt, String type);

	public List<Mensaje> findAll();

	public ResponseEntity<List<Object[]>> findPublishersAll(String jwt);

	public List<Mensaje> findResponsesInMessage(String jwt, int number);

	public List<Mensaje> getPublications(String jwt, int isPublication, int messageIdOne);

	public StarCalification updateStar(int idMessage, String jwt, int number);
}
