package com.codex.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;

	@Size(min = 3, message = "El nombre debe de tener minimo 5 caracteres")
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 50, nullable = false)
	private String apellido;

	@Column(name = "edad", length = 3, nullable = false)
	private Integer edad;

	@Column(name = "puesto", length = 50, nullable = false)
	private String puesto;

	@Column(name = "sexo", length = 10, nullable = false)
	private String sexo;

	@Column(name = "direccion", length = 300, nullable = false)
	private String direccion;

	@Column(name = "salario", length = 10, nullable = false)
	private Double salario;

	@Column(name = "telefono", length = 10, nullable = false)
	private String telefono;

	@Column(name = "nss", length = 15, nullable = false)
	private String nss;

	// ISODATE 2019-10-01T05:00:00.000Z
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_alta;

	// ISODATE 2019-10-01T05:00:00.000Z
	//@JsonSerialize(using = ToStringSerializer.class)
	//private LocalDateTime fecha_baja;

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public LocalDateTime getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(LocalDateTime fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

}
