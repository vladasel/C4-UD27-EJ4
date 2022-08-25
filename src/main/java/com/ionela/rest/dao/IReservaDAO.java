package com.ionela.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ionela.rest.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva,Long>{

}
