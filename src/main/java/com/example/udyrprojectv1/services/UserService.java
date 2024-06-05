package com.example.udyrprojectv1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.udyrprojectv1.entities.Usuario;
import com.example.udyrprojectv1.entities.dtos.LoginData;
import com.example.udyrprojectv1.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Usuario usuarioExiste(String email) {
		return userRepository.findUsuarioByEmail(email);
	}
	
	public Boolean verificaCredenciais(Usuario usuario, LoginData formData) {
		if(usuario.getPassword().equals(formData.getPassword()) && usuario.getEmail().equals(formData.getEmail())) {
			return true;
		}
		return false;
	}

}
