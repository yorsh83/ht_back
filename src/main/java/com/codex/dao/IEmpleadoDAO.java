package com.codex.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codex.model.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Integer> {

}
