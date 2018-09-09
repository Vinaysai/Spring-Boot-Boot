package com.pawana.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pawana.bean.Student;

@Service
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Student getEmployee(String id) {

		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>(id,header);

		ResponseEntity<Student> exchange = restTemplate.exchange("http://localhost:8081/api/client/retriveallclients/{id}",
				HttpMethod.GET, entity, Student.class,id);

		
		return exchange.getBody();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllEmployees() {

		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(header);

		ResponseEntity<List> exchange = restTemplate.exchange("http://localhost:8081/api/client/retriveallclients",
				HttpMethod.GET, entity, List.class);

		return exchange.getBody();
	}

	@Override
	public Student addEmployee(Student emp) {

		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<Student> entity = new HttpEntity<Student>(emp, header);

		ResponseEntity<Student> exchange = restTemplate.exchange("http://localhost:8081/api/create",
				HttpMethod.POST, entity, Student.class,emp);

		return exchange.getBody();

	}

	@Override
	public Student updateEmployee(Student emp) {
		
		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<Student> entity = new HttpEntity<Student>(emp, header);

		ResponseEntity<Student> exchange = restTemplate.exchange("http://localhost:8081/api/client/update/{id}",
				HttpMethod.POST, entity, Student.class,emp.getId(),emp);

		return exchange.getBody();

	}
	
	
	@Override
	public Student deleteStudent(String id) {
		
		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>(id, header);

		ResponseEntity<Student> exchange = restTemplate.exchange("http://localhost:8081/api/client/delete/{id}",
				HttpMethod.POST, entity, Student.class,id);

		return exchange.getBody();

	}

}
