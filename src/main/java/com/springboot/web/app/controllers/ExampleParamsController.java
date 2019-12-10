package com.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ExampleParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(required=false, defaultValue="Algun valor") String text, Model model) {
		model.addAttribute("result", "El texto enviado es: " + text);
		
		return "params/show";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer number, Model model) {
		model.addAttribute("result", "El saludo enviado es: '" + saludo + "' y el número es '" + number + "'");
		
		return "params/show";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer number = null;
		try {
			number = Integer.parseInt(request.getParameter("number"));
		} catch(NumberFormatException e) {
			number = 0;
		}
		
		model.addAttribute("result", "El saludo enviado es: '" + saludo + "' y el número es '" + number + "'");
		
		return "params/show";
	}
}
