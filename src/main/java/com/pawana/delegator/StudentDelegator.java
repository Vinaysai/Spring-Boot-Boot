package com.pawana.delegator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pawana.bean.Student;
import com.pawana.dao.StudentDao;

@Component
public class StudentDelegator {

	@Autowired
	private StudentDao dao;

	public Student getEmployee(String id) {

		if (id == null)
			return null;
		else {
			return dao.getEmployee(id);
		}
	}

	public Student addEmployee(Student emp) {

		if (emp == null || emp.getId() == null || emp.getId().isEmpty()) {
			return null;

		} else {
			return dao.addEmployee(emp);
		}
	}

	public Student updateEmployee(Student emp) {

		if (emp == null || emp.getId() == null || emp.getId().isEmpty()) {
			return null;

		} else {
			return dao.updateEmployee(emp);
		}
	}

	public String deleteEmployee(String id) {

		if (id == null || id.isEmpty()) {
			return null;

		} else {
			Student deleteStudent = dao.deleteStudent(id);

			if (deleteStudent == null)
				return "deleted";

			else
				return "";
		}
	}

	public List<Student> getAllStudent() {

		return dao.getAllEmployees();
	}
}
