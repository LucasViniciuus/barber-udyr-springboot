package com.example.udyrprojectv1.controllers;

import com.example.udyrprojectv1.entities.dtos.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class AccountController {

	@GetMapping("/perfil")
	public ModelAndView abrirPaginaPerfil(HttpSession session) {
		ModelAndView mv = new ModelAndView("profile");
		UserDto dto = (UserDto) session.getAttribute("usuario");
		if (dto != null) {
			mv.addObject("usuario", dto);
			return mv;
		}
		mv.setViewName("index");
		return mv;
	}
}
