package com.upchat.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.upchat.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtil {
	private String secretKey = "mypassworrdforjwtADDMERCRISTHIANCODE@1";
	SecretKey keyGenerate;

	public JwtUtil() {
		super();

		keyGenerate = Keys.hmacShaKeyFor(secretKey.getBytes());
	}

	public String JwtGenerateUser(Usuario user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", user.getIdUsuario());
		claims.put("nombre", user.getNombre());
		claims.put("correo", user.getCorreo());
		claims.put("idRol", user.getRol().getIdRol());

		String jwt = Jwts.builder()
				.claims(claims)
				.subject(user.getCorreo())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
				.signWith(keyGenerate)
				.compact();

		return jwt;
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser()
				.verifyWith(keyGenerate)
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}

	public boolean isJwtValid(String jwt){
		try{
			Jwts.parser()
			.verifyWith(keyGenerate)
			.build()
			.parseSignedClaims(jwt);

			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
