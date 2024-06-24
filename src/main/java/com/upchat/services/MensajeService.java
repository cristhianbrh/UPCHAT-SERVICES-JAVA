package com.upchat.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upchat.dtos.messageCreateNewDto;
import com.upchat.dtos.messageGetAllInfoDto;
import com.upchat.dtos.messageGetAllInfoQuery;
import com.upchat.dtos.messageGetAllInfo_userDto;
import com.upchat.model.Categoria;
import com.upchat.model.Mensaje;
import com.upchat.model.StarCalification;
import com.upchat.model.Usuario;
import com.upchat.repositorio.ICategoriaRepo;
import com.upchat.repositorio.IMensajeRepo;
import com.upchat.repositorio.IUsuarioRepo;
import com.upchat.utils.JwtUtil;

import io.jsonwebtoken.Claims;

@Service
public class MensajeService implements IMensajeService {
	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	IUsuarioRepo usuarioRepo;

	@Autowired
	IMensajeRepo mensajeRepo;

	@Autowired
	ICategoriaRepo categoriaRepo;

	@Override
	public ResponseEntity<String> CrearMensaje(messageCreateNewDto mensaje, String jwt, String type) {
		Claims claim = jwtUtil.extractAllClaims(jwt);

		int idUser = ((Number) claim.get("id")).intValue();
		Mensaje newMessage = new Mensaje();

		Optional<Usuario> user = usuarioRepo.findById(idUser);

		if (!user.isPresent()) {
			return new ResponseEntity<>("Tu usuario no existe", HttpStatus.NOT_FOUND);
		}
		if (type == "newResponse") {
			Optional<Mensaje> mensajeFather = mensajeRepo.findById(mensaje.idMensajeReferencia);
			if (!mensajeFather.isPresent()) {
				return new ResponseEntity<>("El mensaje al que quieres responder no existe", HttpStatus.NOT_FOUND);
			}

		}

		Optional<Categoria> categoria = categoriaRepo.findById(mensaje.idCategoria);

		if (!categoria.isPresent()) {
			return new ResponseEntity<>("La categoría no existe", HttpStatus.NOT_FOUND);
		}
		System.out.println(categoria);
		newMessage.setIdMensajeReferencia(mensaje.idMensajeReferencia);
		newMessage.setAsunto(mensaje.asunto);
		newMessage.setMessag(mensaje.messag);
		newMessage.setEstrellas(0);
		newMessage.setEstado(true);
		newMessage.setUsuario(user.get());
		newMessage.setCategoria(categoria.get());
		System.out.println(categoria.get().toString());
		System.out.println(user.get().toString());
		System.out.println(newMessage.toString());
		mensajeRepo.save(newMessage);

		return new ResponseEntity<>("Insertado correctamente", HttpStatus.OK);

		// Usuario user = new Usuario();
		// user.setIdUsuario(((Number) claim.get("id")).intValue());
		// user.setCorreo(((String) claim.get("correo")));
		// user.setNombre(((String) claim.get("nombre")));
		// TODO Auto-generated method stub
	}

	@Override
	public List<Mensaje> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Object[]>> findPublishersAll(String jwt) {
		return this.getPublicationsAndResponses(jwt, -1);
	}

	@Override
	public ResponseEntity<List<Object[]>> findResponsesInMessage(String jwt, int number) {
		return this.getPublicationsAndResponses(jwt, number);
	}

	private ResponseEntity<List<Object[]>> getPublicationsAndResponses(String jwt, int number){
		Claims claim = jwtUtil.extractAllClaims(jwt);
		int idUser = ((Number) claim.get("id")).intValue();

		Optional<Usuario> user = usuarioRepo.findById(idUser);
		if (!user.isPresent()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		List<Object[]> messagesList = mensajeRepo.findCustomMessages(idUser, number);
		return new ResponseEntity<>(messagesList, HttpStatus.OK);
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

	@Override
	public String toString() {
		return "MensajeService [jwtUtil=" + jwtUtil + ", usuarioRepo=" + usuarioRepo + ", mensajeRepo=" + mensajeRepo
				+ ", categoriaRepo=" + categoriaRepo + "]";
	}

}
