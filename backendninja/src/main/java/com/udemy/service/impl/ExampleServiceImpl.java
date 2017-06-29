package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	@Override
	public List<Person> getListPeople() {		
		List<Person> people =  new ArrayList<>();

		people.add(new Person("Jonh", 23));
		people.add(new Person("Isaac",30));
		people.add(new Person("Eva", 43));
		people.add(new Person("Peter", 18));
		LOG.info("--HELLOW SERVICE--");
		return people;
	}



}
