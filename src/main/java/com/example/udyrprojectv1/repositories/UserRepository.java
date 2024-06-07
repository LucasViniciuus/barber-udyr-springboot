package com.example.udyrprojectv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.udyrprojectv1.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "SELECT * from public.usuario u  WHERE email = ?1 and cpf = ?2", nativeQuery = true) 
	public Usuario findUsuarioByEmailAndCpf(String email, String cpf);
	
	@Query(value = "SELECT * from public.usuario u  WHERE email = ?1", nativeQuery = true) 
	public Usuario findUsuarioByEmail(String email);


}
