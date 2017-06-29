package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

	//Transformamar de una Entity --> Model
	public CourseModel entityToModel(Course course){
		CourseModel courseModel = new CourseModel();
		courseModel.setId(course.getId());
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
		
		return courseModel;
	}
	

	//Transformamar de una Model --> Entity
	public Course modelToEntity(CourseModel courseModel){
		Course course = new Course();
		course.setId(courseModel.getId());
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());
		
		return course;
	}
}
