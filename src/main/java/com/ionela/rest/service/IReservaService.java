package com.ionela.rest.service;

import java.util.List;

import com.ionela.rest.dto.Reserva;

public interface IReservaService {
	public List<Reserva> listarReservas();

	public Reserva guardarReserva(Reserva reserva);

	public Reserva reservaXID(Long id);

	public Reserva actualizarReserva(Reserva reserva);

	public void eliminarReserva(Long id);
}
