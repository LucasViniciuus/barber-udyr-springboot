package com.example.udyrprojectv1.controllers;

import com.example.udyrprojectv1.entities.dtos.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class Products {
	
	@GetMapping("/abrirExibicaoProdutos")
	public ModelAndView abrirVisualizaoProdutos(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		UserDto usuario =  (UserDto) session.getAttribute("usuario");
		mv.addObject("usuario", usuario);
		mv.setViewName("products");
		return mv;
	}

}
