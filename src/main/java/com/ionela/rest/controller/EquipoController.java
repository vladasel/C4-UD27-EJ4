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

import com.ionela.rest.dto.Equipo;
import com.ionela.rest.service.EquipoServiceImpl;



@RestController
@RequestMapping("/api")
public class EquipoController {
	
	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos() {
		return equipoServiceImpl.listarEquipos();
	}

	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {

		return equipoServiceImpl.guardarEquipo(equipo);
	}

	@GetMapping("/equipos/{id}")
	public Equipo equipoXID(@PathVariable(name = "id") String id) {

		return equipoServiceImpl.equipoXID(id);
	}

	@PutMapping("/equipos/{id}")
	public Equipo actualizarEquipo(@PathVariable(name = "id") String id, @RequestBody Equipo equipo) {

		Equipo seleccionado = new Equipo();
		Equipo actualizado = new Equipo();

		seleccionado = equipoServiceImpl.equipoXID(id);

		seleccionado.setNombre(equipo.getNombre());
		seleccionado.setFacultad(equipo.getFacultad());

		actualizado = equipoServiceImpl.actualizarEquipo(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/equipos/{id}")

	public void eleiminarEquipo(@PathVariable(name = "id") String id) {
		equipoServiceImpl.eliminarEquipo(id);
	}
}
