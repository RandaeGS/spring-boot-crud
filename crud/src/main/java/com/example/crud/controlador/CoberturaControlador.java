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

	@GetMapping("/modificar/{id}")
	public String formularioModificar(@PathVariable String id, Model model){

		for (Cobertura cobertura: coberturaList){
			if (cobertura.getId().equals(id)){
				model.addAttribute("cobertura", cobertura);
			}
		}

		return "registrar";
	}

	@PostMapping("/modificar")
	public String modificar(@ModelAttribute Cobertura cobertura, @RequestParam("id") String id){

		for (Cobertura aux: coberturaList){
			if (aux.getId().equals(id)){
				aux.setDescripcion(cobertura.getDescripcion());
				aux.setRiesgo(cobertura.getRiesgo());
				aux.setMontoCobertura(cobertura.getMontoCobertura());
				aux.setPorcentajeCobertura(cobertura.getPorcentajeCobertura());
				aux.setDeducible(cobertura.getDeducible());
			}
		}

		return "redirect:/";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable String id){
		coberturaList.removeIf(cobertura -> cobertura.getId().equals(id));
		return "redirect:/";
	}
}
