package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/example")
public class EjemploController {
	
	public static final String EXAMPLE_VIEW = "ejemplo";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	//Primera forma	-> Usar para cuando se hacen redirecciones y no hay que insertar datos o son muy pocos
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET) --> Otra forma del Mapping
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		exampleComponent.sayHello();
		model.addAttribute("name", "Jonh");
		model.addAttribute("ver", "Estoy viendo");
		model.addAttribute("person", new Person("Jonh", 23));
		model.addAttribute("people", exampleService.getListPeople());
		
		return EXAMPLE_VIEW;
	}
	
	//Segunda Forma -> Usar para cuando hay que insertar muchos datos en las plantillas
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET) --> Otra forma del Mapping
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		
		mav.addObject("name", "Isaac");
		mav.addObject("ver", "Ver pro");
		mav.addObject("person", new Person("Isaac", 30));
		mav.addObject("person", new Person("Isaac", 30));
		mav.addObject("people", exampleService.getListPeople());
		
		//return new ModelAndView(EXAMPLE_VIEW);
		return mav;
	}
	
	
}
