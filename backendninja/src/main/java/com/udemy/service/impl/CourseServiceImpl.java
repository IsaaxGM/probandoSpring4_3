package com.udemy.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaReppsitory;
import com.udemy.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaReppsitory courseJpaRepository;
	
	@Override
	public List<Course> listAllCourse() {
		LOG.info("Call: listAllCourse()");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("Call: addCourse");
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);		
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		// Si el objeto course tine id va a la BD verifica si existe y lo reemplaza
		return courseJpaRepository.save(course);
	}

}
