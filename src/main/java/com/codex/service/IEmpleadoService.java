package com.codex.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.codex.model.Empleado;

public interface IEmpleadoService extends ICRUD<Empleado> {

	Page<Empleado> listarPageable(Pageable pageable);

}
