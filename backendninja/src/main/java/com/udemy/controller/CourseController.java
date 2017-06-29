package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final Log LOG = LogFactory.getLog(CourseController.class);
	private static final String COURSES_VIEW = "courses";
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses(){
		LOG.info("Call: listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new Course()); // Objeto vacio para el form para que thymeleaf
		mav.addObject("courses", courseService.listAllCourse());
		return mav;
	}
	
	@PostMapping("/addcourses")
	public String addCourse(@ModelAttribute("courseModel") CourseModel courseModel ){
		LOG.info("Call: addCourse() -- Param: " + courseConverter.modelToEntity(courseModel).toString());
		courseService.addCourse(courseConverter.modelToEntity(courseModel));
		return "redirect:/courses/listcourses";
	}
	
	@PostMapping("/updCourse")
	public String updCourse(@ModelAttribute("courseModel") CourseModel courseModel){
		LOG.info("Call: updCourse() -- Param: " + courseConverter.modelToEntity(courseModel).toString());
		courseService.updateCourse(courseConverter.modelToEntity(courseModel));		
		return "redirect:/courses/listcourses";
	}
	
	@PostMapping("/delCourse")
	public String delCourse(@ModelAttribute("courseModel") CourseModel courseModel){
		LOG.info("Call: delCourse() -- Param: " + courseConverter.modelToEntity(courseModel).toString());
		Course c = courseConverter.modelToEntity(courseModel);
		LOG.info("Id a eleminara: " + c.getId() );
		courseService.removeCourse(c.getId());
		return "redirect:/courses/listcourses";
	}
}
