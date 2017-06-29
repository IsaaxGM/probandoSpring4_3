package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.service.EjercicioService;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService {

	private static final Log LOG = LogFactory.getLog(EjercicioServiceImpl.class);
	
	@Override
	public void pintarLog() {
		LOG.info("[--ESTOY EN EL SERVICE DEÑ EJERCICIO--]");
	}

}
