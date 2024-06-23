package com.upchat.utils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordUtil {
	public String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	public boolean verifyPassword(String plainText, String hashedPassword) {
		return BCrypt.checkpw(plainText, hashedPassword);
	}
}
