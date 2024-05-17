package com.example.udyrprojectv1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("v1")
public class AuthController {

	@GetMapping("/abrirPaginaRegistro")
	public ModelAndView abrirPaginaRegistro() {
		return new ModelAndView("register");
	}

	@PostMapping("/salvarRegistro")
	public ModelAndView salvarRegistro() {
		return null; // em construção
	}

	@GetMapping("/abrirPaginaLogin")
	public ModelAndView abrirPaginaLogin() {
		return new ModelAndView("login");
	}

	@PostMapping("/verificarCredenciais")
	public ModelAndView verificarCredenciais() {
		return null; // em construção.
	}

	@GetMapping("/esqueciSenha")
	public ModelAndView esqueciSenha() {
		return new ModelAndView("senhaEsquecida"); // em construção
	}
}
