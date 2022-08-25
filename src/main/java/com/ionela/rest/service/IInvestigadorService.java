package com.ionela.rest.service;

import java.util.List;

import com.ionela.rest.dto.Investigador;


public interface IInvestigadorService {
	public List<Investigador> listarInvestigadores();

	public Investigador guardarInvestigador(Investigador investigador);

	public Investigador investigadorXID(String id);

	public Investigador actualizarInvestigador(Investigador investigador);

	public void eliminarInvestigador(String id);
}
