package com.examencaoa.examencaoa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.examencaoa.examencaoa.commons.GenericServiceImpl;
import com.examencaoa.examencaoa.dao.api.EmpleadosDaoApi;
import com.examencaoa.examencaoa.model.Empleados;
import com.examencaoa.examencaoa.service.api.EmpleadosServiceApi;

@Service
public class EmpleadosServiceImpl extends GenericServiceImpl<Empleados,Long> implements EmpleadosServiceApi {

	@Autowired
	private EmpleadosDaoApi empleadosDaoApi;
	@Override
	public CrudRepository<Empleados, Long> getDao() {
	
		return empleadosDaoApi;
	}

}
