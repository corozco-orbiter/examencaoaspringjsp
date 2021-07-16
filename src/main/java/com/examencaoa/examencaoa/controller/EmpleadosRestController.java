package com.examencaoa.examencaoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examencaoa.examencaoa.model.Empleados;
import com.examencaoa.examencaoa.service.api.EmpleadosServiceApi;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class EmpleadosRestController {

	@Autowired
	private EmpleadosServiceApi empleadosServiceApi;

	@GetMapping(value = "/all")
	public List<Empleados> getAll() {
		return empleadosServiceApi.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Empleados find(@PathVariable Long id) {
		return empleadosServiceApi.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Empleados> save(@RequestBody Empleados empleados) {
		Empleados obj = empleadosServiceApi.save(empleados);
		return new ResponseEntity<Empleados>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Empleados> delete(@PathVariable Long id) {
		Empleados empleados = empleadosServiceApi.get(id);
		if (empleados != null) {
			empleadosServiceApi.delete(id);
		} else {
			return new ResponseEntity<Empleados>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Empleados>(empleados, HttpStatus.OK);
	}
}
