package com.example.udyrprojectv1.controllers;

import com.example.udyrprojectv1.entities.dtos.UserDto;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

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
	public ModelAndView abrirPaginaRegistro(ModelMap model) {
		model.addAttribute("registro", new Usuario());
		return new ModelAndView("register", model);
	}

	@PostMapping("/salvarRegistro")
	public ModelAndView salvarRegistro(@ModelAttribute("registro") Usuario usuario) {
		Usuario usuarioExist = userRepository.findUsuarioByEmailAndCpf(usuario.getEmail(), usuario.getCpf());
		if (usuarioExist == null) {
			usuario.setPassword(hashService.hashSenha(usuario.getPassword()));
			userRepository.save(usuario);
			return new ModelAndView("index");
		}
		return new ModelAndView("register");

	}

	@GetMapping("/abrirPaginaLogin")
	public ModelAndView abrirPaginaLogin(ModelMap model) {
		model.addAttribute("loginData", new LoginData());
		return new ModelAndView("login", model);
	}

	@PostMapping("/verificarCredenciais")
	public ModelAndView verificarCredenciais(LoginData credentials, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (credentials != null) {
			Usuario usuario = userService.usuarioExiste(credentials.getEmail());
			if (usuario != null) {
				if (hashService.verificarCredenciais(credentials.getPassword(), usuario.getPassword())) {

					session.setAttribute("usuario", new UserDto(usuario.getId(), usuario.getName(), usuario.getAge(), usuario.getEmail(), usuario.getCpf()));
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

	@GetMapping("/recuperarSenha")
	public ModelAndView esqueciSenha() {
		return new ModelAndView("forgotpassword");
	}

	@GetMapping("/sairDoPerfil")
	public ModelAndView sairDoPerfil(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
