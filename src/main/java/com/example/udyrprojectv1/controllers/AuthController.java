package com.example.udyrprojectv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.udyrprojectv1.entities.Usuario;
import com.example.udyrprojectv1.entities.dtos.LoginData;
import com.example.udyrprojectv1.repositories.UserRepository;
import com.example.udyrprojectv1.services.HashService;
import com.example.udyrprojectv1.services.UserService;

@RestController
@RequestMapping("")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private HashService hashService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/abrirPaginaRegistro")
	public ModelAndView abrirPaginaRegistro() {
		return new ModelAndView("register");
	}

	@PostMapping("/salvarRegistro")
	public ModelAndView salvarRegistro(@RequestBody Usuario usuario) {

		usuario.setPassword(hashService.hashSenha(usuario.getPassword()));
		userRepository.save(usuario);
		return new ModelAndView("index");

	}

	@GetMapping("/abrirPaginaLogin")
	public ModelAndView abrirPaginaLogin(ModelMap model) {
		model.addAttribute("loginData", new LoginData());
		return new ModelAndView("login", model);
	}

	@PostMapping("/verificarCredenciais")
	public ModelAndView verificarCredenciais(@RequestBody LoginData credentials) {
		ModelAndView mv = new ModelAndView();
		if (credentials != null) {
			Usuario usuario = userService.usuarioExiste(credentials.getEmail());
			if (usuario != null) {
				if (hashService.verificarCredenciais(credentials.getPassword(), usuario.getPassword())) {
					return new ModelAndView("redirect:/index");
				}
				mv.addObject("mensagemErro", "Credenciais incorretas. Por favor, tente novamente.");
				return new ModelAndView("login", mv.getModel());
			}
			mv.addObject("mensagemErro", "Usuário não encontrado. Por favor, registre-se.");
			return new ModelAndView("login", mv.getModel());
		}
		return mv.addObject("mensagemErro", "Erro ao processar as credenciais. Por favor, tente novamente.");
	}

	@GetMapping("/esqueciSenha")
	public ModelAndView esqueciSenha() {
		return new ModelAndView("senhaEsquecida");
	}
}
