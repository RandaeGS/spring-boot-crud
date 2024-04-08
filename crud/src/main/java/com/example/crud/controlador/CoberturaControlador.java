package com.example.crud.controlador;

import com.example.crud.controlador.repositorio.CoberturaRepository;
import com.example.crud.modelo.Cobertura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoberturaControlador {

	@Autowired
	private CoberturaRepository coberturaRepository;


	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("coberturas", coberturaRepository.findAll());
		return "index";
	}

	@GetMapping("/cobertura")
	public String formulario(){
		return "registrar";
	}

	@PostMapping("/crear")
	public String crear(@ModelAttribute Cobertura cobertura){
		coberturaRepository.save(cobertura);
		return "redirect:/";
	}

	@GetMapping("/modificar/{id}")
	public String formularioModificar(@PathVariable String id, Model model){

		model.addAttribute("cobertura", coberturaRepository.findById(id).get());

		return "registrar";
	}

	@PostMapping("/modificar")
	public String modificar(@ModelAttribute Cobertura cobertura, @RequestParam("id") String id){

		Cobertura original = coberturaRepository.findById(id).get();
		original.setDescripcion(cobertura.getDescripcion());
		original.setRiesgo(cobertura.getRiesgo());
		original.setPorcentajeCobertura(cobertura.getPorcentajeCobertura());
		original.setMontoCobertura(cobertura.getMontoCobertura());
		original.setDeducible(cobertura.getDeducible());
		coberturaRepository.save(original);

		return "redirect:/";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable String id){
		coberturaRepository.deleteById(id);
		return "redirect:/";
	}
}
