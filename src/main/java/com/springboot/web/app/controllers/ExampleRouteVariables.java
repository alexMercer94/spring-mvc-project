package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class ExampleRouteVariables {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Enviar parametros de la ruta (PathVariable)");
		return "variables/index";
	}
	
	@GetMapping("/string/{text}")
	public String variables(@PathVariable String text, Model model) {
		model.addAttribute("title", "Recibir parametros de la ruta (PathVariable)");
		model.addAttribute("result", "El texto enviado en la ruta es: " + text);
		return "variables/show";
	}
	
	@GetMapping("/string/{text}/{numero}")
	public String variables(@PathVariable String text, @PathVariable Integer numero, Model model) {
		model.addAttribute("title", "Recibir parametros de la ruta (PathVariable)");
		model.addAttribute("result", "El texto enviado en la ruta es: " + text + " y el número enviado en el path es " + numero);
		return "variables/show";
	}
}
