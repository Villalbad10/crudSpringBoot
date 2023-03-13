package com.crud.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

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

//	con put
	public EmpleadoEntities actualizaCelular(int id, EmpleadoEntities empleadoEntities) {
		// get the product from DB by id
		// update with new value getting from request
		EmpleadoEntities existingProduct = empleadoRepository.findById(id).get(); // DB
		existingProduct.setCelular(empleadoEntities.getCelular());

		return empleadoRepository.save(existingProduct);
	}

	
//	con patch
	public EmpleadoEntities acualizarDato(int id, Map<String, Object> fields) {
		Optional<EmpleadoEntities> existeDato = empleadoRepository.findById(id);

		if (existeDato.isPresent()) {
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(EmpleadoEntities.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existeDato.get(), value);
			});
			return empleadoRepository.save(existeDato.get());
		}
		return null;
	}

}
