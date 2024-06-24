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
		// keyGenerate = Keys.hmacShaKeyFor(secretKey.getBytes());
		// keyGenerate = Jwts.SIG.HS256.key(secretKey).build();
		// keyGenerate = new SecretKeySpec(secretKey.getBytes(),
		// SignatureAlgorithm.HS256.getJcaName());
		keyGenerate = Keys.hmacShaKeyFor(secretKey.getBytes());
	}

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
				.signWith(keyGenerate)
				.compact();
		// Jwts.SIG.HS384.key().build()

		return jwt;
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser()
				.verifyWith(keyGenerate)
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}

	// public Claims extractAllClaims(HttpServiceRequest request) {
	// return
	// Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	// }
}
