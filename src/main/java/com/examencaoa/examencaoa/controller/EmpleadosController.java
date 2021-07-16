package com.examencaoa.examencaoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examencaoa.examencaoa.model.Empleados;
import com.examencaoa.examencaoa.service.api.EmpleadosServiceApi;

@Controller

public class EmpleadosController {
	
	@Autowired
	private EmpleadosServiceApi empleadosServiceApi;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", empleadosServiceApi.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id , Model model) {
		if(id != null && id != 0) {
			model.addAttribute("empleados", empleadosServiceApi.get(id));
		}else {
			model.addAttribute("empleados", new Empleados());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Empleados empleados, Model model) {
		empleadosServiceApi.save(empleados);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		empleadosServiceApi.delete(id);
		
		return "redirect:/";
	}

}
