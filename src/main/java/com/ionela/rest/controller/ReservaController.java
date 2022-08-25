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

import com.ionela.rest.dto.Reserva;
import com.ionela.rest.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {
	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarReservas() {
		return reservaServiceImpl.listarReservas();
	}

	@PostMapping("/reservas")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {

		return reservaServiceImpl.guardarReserva(reserva);
	}

	@GetMapping("/reservas/{id}")
	public Reserva facultadXID(@PathVariable(name = "id") Long id) {

		return reservaServiceImpl.reservaXID(id);
	}

	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") Long id, @RequestBody Reserva reserva) {

		Reserva seleccionado = new Reserva();
		Reserva actualizado = new Reserva();

		seleccionado = reservaServiceImpl.reservaXID(id);

		seleccionado.setEquipo(reserva.getEquipo());
		seleccionado.setInvestigador(reserva.getInvestigador());
		seleccionado.setComienzo(reserva.getComienzo());
		seleccionado.setFin(reserva.getFin());
		

		actualizado = reservaServiceImpl.actualizarReserva(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/reservas/{id}")

	public void eleiminarReserva(@PathVariable(name = "id") Long id) {
		reservaServiceImpl.eliminarReserva(id);
	}
}
