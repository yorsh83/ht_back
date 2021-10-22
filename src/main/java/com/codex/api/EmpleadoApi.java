package com.codex.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codex.exception.ModelNotFoundException;
import com.codex.model.Empleado;
import com.codex.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoApi {

	private static final Logger log = LoggerFactory.getLogger(EmpleadoApi.class);

	@Autowired
	private IEmpleadoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleado>> listado() {
		return new ResponseEntity<List<Empleado>>(service.listar(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Empleado>> listarPorId(@PathVariable("id") Integer id) {
		Optional<Empleado> em = service.listarPorId(id);
		if (!em.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Optional<Empleado>>(em, HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Empleado empl) {
		Empleado em = new Empleado();
		em = service.registrar(empl);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(em.getIdEmpleado())
				.toUri();
		return ResponseEntity.created(location).build();
		// return new ResponseEntity<Empleado>(service.registrar(empl),
		// HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Empleado empl) {
		service.modificar(empl);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<Empleado> em = service.listarPorId(id);
		if (!em.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}

	@GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Empleado>> listarPageable(Pageable pageable) {
		Page<Empleado> empl;
		empl = service.listarPageable(pageable);
		return new ResponseEntity<Page<Empleado>>(empl, HttpStatus.OK);
	}
}
