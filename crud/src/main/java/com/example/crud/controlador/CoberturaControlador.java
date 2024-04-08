package com.example.crud.controlador;

import com.example.crud.modelo.Cobertura;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoberturaControlador {

	List<Cobertura> coberturaList = new ArrayList<>();

	@GetMapping("/")
	public String index(Model model){
		coberturaList.add(new Cobertura("desc", "riesg", 0.22F, 20L, 0.11F));
		model.addAttribute("coberturas", coberturaList);
		return "index";
	}

	@GetMapping("/cobertura")
	public String formulario(){
		return "registrar";
	}

	@PostMapping("/crear")
	public String crear(@ModelAttribute Cobertura cobertura){

		coberturaList.add(cobertura);
		return "redirect:/";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable String id){
		coberturaList.removeIf(cobertura -> cobertura.getId().equals(id));
		System.out.println("Borrar");
		return "redirect:/";
	}
}
