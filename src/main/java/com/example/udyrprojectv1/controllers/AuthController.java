package com.example.udyrprojectv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.udyrprojectv1.entities.Usuario;
import com.example.udyrprojectv1.entities.dtos.LoginData;
import com.example.udyrprojectv1.services.UserService;

@RestController
@RequestMapping("v1")
public class AuthController {

	@Autowired	
	private UserService userService;

	@GetMapping("/abrirPaginaRegistro")
	public ModelAndView abrirPaginaRegistro() {
		return new ModelAndView("register");
	}

	@PostMapping("/salvarRegistro")
	public ModelAndView salvarRegistro() {
		return null; // em construção
	}

	@GetMapping("/abrirPaginaLogin")
	public ModelAndView abrirPaginaLogin(ModelMap model) {
		model.addAttribute("loginData", new LoginData());
		return new ModelAndView("login", model);
	}

	@PostMapping("/verificarCredenciais")
	public ModelAndView verificarCredenciais(LoginData data) {
		ModelAndView modelAndView = new ModelAndView();
		if (data != null) {
			Usuario usuarioExiste = userService.usuarioExiste(data.getEmail());
			if (usuarioExiste != null) {
				Boolean testaCredenciais = userService.verificaCredenciais(usuarioExiste, data);
				if (testaCredenciais) {
					modelAndView.setViewName("redirect:/v1/inicio");
					return modelAndView;
				}
				modelAndView.addObject("mensagemErro", "Credenciais incorretas. Por favor, tente novamente.");
			} else {
				modelAndView.addObject("mensagemErro", "Usuário não encontrado. Por favor, registre-se.");
			}
		} else {
			modelAndView.addObject("mensagemErro", "Erro ao processar as credenciais. Por favor, tente novamente.");
		}
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping("/esqueciSenha")
	public ModelAndView esqueciSenha() {
		return new ModelAndView("senhaEsquecida"); // em construção
	}
}
