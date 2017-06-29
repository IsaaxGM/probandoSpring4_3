package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.service.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

	private static final Log LOG = LogFactory.getLog(EjercicioController.class);	
	private static final String VIEW = "vistaAutoEval";
	
	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService; 
	
	@RequestMapping("/ejercicioString")
	public RedirectView ejercicioString(Model model){
		LOG.info("-- Iniciando redireccion--");
		return new RedirectView("/ejercicio/ejercicoMAV");
	}
	
	@RequestMapping("/ejercicoMAV")
	public ModelAndView ejercicioMAV(){		
		
		LOG.info("Setando vista");
		
		ModelAndView mav = new ModelAndView(VIEW);
		mav.addObject("mensaje", "Soy Ejercio Autoevaluacion");
		
		ejercicioService.pintarLog();
		
		return mav;
	}
}
