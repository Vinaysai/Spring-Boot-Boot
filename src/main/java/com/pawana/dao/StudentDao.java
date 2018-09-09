package com.pawana.dao;

import java.util.List;

import com.pawana.bean.Student;

public interface StudentDao {
	
	public Student getEmployee(String id);
	
	public List<Student> getAllEmployees();
	
	public Student addEmployee(Student emp);
	
	public Student updateEmployee(Student emp);
	
	
	public Student deleteStudent(String id);

}
