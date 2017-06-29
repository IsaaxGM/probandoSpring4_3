package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaReppsitory;

@Component("exampleComponent")
public class ExampleComponent {

	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaReppsitory courseJpaRepository;
	
	public void sayHello(){
		
		LOG.info("HELLO FRONT EXAMPLECOMPONENT");
	}
}
