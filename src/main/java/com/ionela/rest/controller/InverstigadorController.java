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


import com.ionela.rest.dto.Investigador;
import com.ionela.rest.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InverstigadorController {
	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadores() {
		return investigadorServiceImpl.listarInvestigadores();
	}

	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {

		return investigadorServiceImpl.guardarInvestigador(investigador);
	}

	@GetMapping("/investigadores/{id}")
	public Investigador investigadorXID(@PathVariable(name = "id") String id) {

		return investigadorServiceImpl.investigadorXID(id);
	}

	@PutMapping("/investigadores/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name = "id") String id, @RequestBody Investigador investigador) {

		Investigador seleccionado = new Investigador();
		Investigador actualizado = new Investigador();

		seleccionado = investigadorServiceImpl.investigadorXID(id);

		seleccionado.setNom_apell(investigador.getNom_apell());
		seleccionado.setFacultad(investigador.getFacultad());

		actualizado = investigadorServiceImpl.actualizarInvestigador(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/investigadores/{id}")

	public void eleiminarInvestigador(@PathVariable(name = "id") String id) {
		investigadorServiceImpl.eliminarInvestigador(id);
	}
}
