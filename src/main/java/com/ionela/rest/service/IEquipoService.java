package com.ionela.rest.service;

import java.util.List;

import com.ionela.rest.dto.Equipo;

public interface IEquipoService {
	public List<Equipo> listarEquipos();

	public Equipo guardarEquipo(Equipo equipo);

	public Equipo equipoXID(String id);

	public Equipo actualizarEquipo(Equipo equipo);

	public void eliminarEquipo(String id);
}
