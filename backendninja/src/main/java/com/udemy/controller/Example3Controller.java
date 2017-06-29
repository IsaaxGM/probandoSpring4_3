package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);	
	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	//Forma #1 de redireccionar una url no especificada como http://localhost:8080/example3/
	/*@GetMapping("/")
	public String redirect(){
		return "redirect:/example3/showform";
	}
	
	//Para Cuando ponen: http://localhost:8080/example3 --> Sin la "/"
	@GetMapping("")
	public String redirect2(){
		return "redirect:/example3/showform";
	}
	*/
	
	//Forma #2 con redirect la forma que propone Spring
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/example3/showform");
	}
	
	//Para Cuando ponen: http://localhost:8080/example3 --> Sin la "/"
	@GetMapping("")
	public RedirectView redirect2(){
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model){
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG");
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	/*@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person){
		LOGGER.info("METODO: 'addPerson' -- PARAMS: '" + person + "'");
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'" );
		return mav;
	}*/
	
	/*Ejemplo para validacion del formulario*/
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindigResult){
		ModelAndView mav = new ModelAndView();
		
		if(bindigResult.hasErrors()){
			mav.setViewName(FORM_VIEW);
		}else{
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}
		
		return mav;
	}
	
}
