package com.mundial.selecciones;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("")
	public String verPagiaInicio() {
		return "index";
	}

}
