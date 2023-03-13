package com.crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.EmpleadoEntities;
import com.crud.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping()
	public List<EmpleadoEntities> listarEmpleados() {
		return empleadoService.listarEmpleados();
	}

	@PostMapping
	public EmpleadoEntities insertarEmpleado(@RequestBody EmpleadoEntities empleadoEntities) {
		return empleadoService.insertar(empleadoEntities);
	}

	@PutMapping
	public EmpleadoEntities actualizarEmpleado(@RequestBody EmpleadoEntities empleadoEntities) {
		return empleadoService.actualizar(empleadoEntities);
	}

	@PatchMapping("/{id}")
	public EmpleadoEntities updateProductFields(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		return empleadoService.acualizarDato(id, fields);
	}

	@PutMapping("/cel/{id}")
	public EmpleadoEntities actualizaCel(@PathVariable int id, @RequestBody EmpleadoEntities productRequest) {
		return empleadoService.actualizaCelular(id, productRequest);
	}

	@DeleteMapping
	public void eliminarEmpleado(@RequestBody EmpleadoEntities empleadoEntities) {
		empleadoService.eliminarEmpleado(empleadoEntities);
	}
}
