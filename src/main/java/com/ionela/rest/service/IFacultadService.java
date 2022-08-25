package com.ionela.rest.service;

import java.util.List;

import com.ionela.rest.dto.Facultad;


public interface IFacultadService {
	public List<Facultad> listarFacultades();

	public Facultad guardarFacultad(Facultad facultad);

	public Facultad facultadXID(Long id);

	public Facultad actualizarFacultad(Facultad facultad);

	public void eliminarFacultad(Long id);
}
