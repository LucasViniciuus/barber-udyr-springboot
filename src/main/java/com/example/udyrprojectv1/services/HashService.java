package com.example.udyrprojectv1.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HashService {
	
	public String hashSenha(String senha) {
		return BCrypt.hashpw(senha, BCrypt.gensalt());
	}
	
	public Boolean verificarCredenciais(String senha, String hashSenha) {
		return BCrypt.checkpw(senha, hashSenha);
	}
	
	

}
