package com.crud.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLEADOS")
public class EmpleadoEntities {

	@Id
	@Column(name = "CODIGO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO")
	private String apellido;

	@Column(name = "EDAD")
	private Integer edad;

	@Column(name = "CEDULA", unique = true)
	private Integer cedula;

	@Column(name = "CELULAR", length = 10)
	private String celular;

	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;
}
