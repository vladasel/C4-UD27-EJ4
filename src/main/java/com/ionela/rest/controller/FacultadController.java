package com.ionela.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ionela.rest.dto.Facultad;
import com.ionela.rest.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {
	
	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultad> listarFacultad() {
		return facultadServiceImpl.listarFacultades();
	}

	@PostMapping("/facultades")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {

		return facultadServiceImpl.guardarFacultad(facultad);
	}

	@GetMapping("/facultades/{id}")
	public Facultad facultadXID(@PathVariable(name = "id") Long id) {

		return facultadServiceImpl.facultadXID(id);
	}

	@PutMapping("/facultades/{id}")
	public Facultad actualizarFacultad(@PathVariable(name = "id") Long id, @RequestBody Facultad facultad) {

		Facultad seleccionado = new Facultad();
		Facultad actualizado = new Facultad();

		seleccionado = facultadServiceImpl.facultadXID(id);

		seleccionado.setNombre(facultad.getNombre());
		

		actualizado = facultadServiceImpl.actualizarFacultad(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/facultades/{id}")

	public void eleiminarFacultad(@PathVariable(name = "id") Long id) {
		facultadServiceImpl.eliminarFacultad(id);
	}

}
