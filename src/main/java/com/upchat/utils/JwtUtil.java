package com.upchat.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.upchat.model.Usuario;

import io.jsonwebtoken.Jwts;

@Service
public class JwtUtil {
	private String secretKey = "mypassworrdforjwt";

	public String JwtGenerateUser(Usuario user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", user.getIdUsuario());
		claims.put("nombre", user.getNombre());
		claims.put("correo", user.getCorreo());
		claims.put("idRol", user.getRol().getIdRol());

		// byte[] secByte = secretKey.getBytes();
		// Key secKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String jwt = Jwts.builder()
				.claims(claims)
				.subject(user.getCorreo())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
				.signWith(Jwts.SIG.HS384.key().build())
				.compact();

		return jwt;
	}

	// public Claims extractAllClaims(HttpServiceRequest request) {
	// return
	// Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	// }
}
