package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entities.EmpleadoEntities;
import com.crud.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	public EmpleadoEntities insertar(EmpleadoEntities empleadoEntities) {
		return empleadoRepository.save(empleadoEntities);
	}

	public EmpleadoEntities actualizar(EmpleadoEntities empleadoEntities) {
		return empleadoRepository.save(empleadoEntities);
	}

	public List<EmpleadoEntities> listarEmpleados() {
		return empleadoRepository.findAll();
	}

	public void eliminarEmpleado(EmpleadoEntities empleadoEntities) {
		empleadoRepository.delete(empleadoEntities);
	}
}
