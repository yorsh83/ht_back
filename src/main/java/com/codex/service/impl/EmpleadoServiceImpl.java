package com.codex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codex.dao.IEmpleadoDAO;
import com.codex.model.Empleado;
import com.codex.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoDAO dao;

	@Override
	public Empleado registrar(Empleado t) {
		return dao.save(t);
	}

	@Override
	public Empleado modificar(Empleado t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Empleado> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Empleado> listar() {
		return dao.findAll();
	}

	@Override
	public Page<Empleado> listarPageable(Pageable pageable) {
		return dao.findAll(pageable);
	}

}
