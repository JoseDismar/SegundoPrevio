package com.mundial.selecciones.seleccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mundial.selecciones.continente.Continente;
import com.mundial.selecciones.continente.ContinenteRepository;

@Controller
public class SeleccionController {
	@Autowired
	SeleccionRepository seleccionRepository;
	@Autowired
	ContinenteRepository continenteRepository;
	
	@GetMapping("/selecciones/nueva")
	public String formularioNuevaSeleccion(Model modelo) {
		List<Continente> listaContinentes=continenteRepository.findAll();
		modelo.addAttribute("listaContinentes",listaContinentes);
		modelo.addAttribute("seleccion",new Seleccion());
		return"seleccion_formulario";
	}
	
	@PostMapping("/selecciones/guardar")
	public String guardarSeleccion(Seleccion seleccion) {
		seleccionRepository.save(seleccion);
		return "redirect:/";
	}
	
	@GetMapping("/selecciones")
	public String listarSelecciones(Model modelo) {
		List<Seleccion> listaSelecciones=seleccionRepository.findAll();
		modelo.addAttribute("listaSelecciones",listaSelecciones);
		return "selecciones";
	}
	
	@GetMapping("/selecciones/editar/{id}")
	public String mostarFormularioModificarSeleccion(@PathVariable("id") Integer id, Model modelo){
		Seleccion seleccion=seleccionRepository.findById(id).get();
		modelo.addAttribute("seleccion",seleccion);
		List<Continente> listaContinentes=continenteRepository.findAll();
		
		modelo.addAttribute("listaContinentes", listaContinentes);
		return"selecciones_formulario";
		
	}
	
	@GetMapping("/selecciones/eliminar/{id}")
	public String eliminarSeleccion(@PathVariable("id") Integer id, Model modelo) {
		seleccionRepository.deleteById(id);
		return "redirect:/selecciones";
	}
	
	
}
