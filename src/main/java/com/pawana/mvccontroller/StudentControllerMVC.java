package com.pawana.mvccontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pawana.bean.Student;
import com.pawana.delegator.StudentDelegator;

@Controller
public class StudentControllerMVC {

	@Autowired
	private StudentDelegator employeeDelegator;

	@RequestMapping(value = "/getEmpDetails", method = RequestMethod.GET)
	public ModelAndView getEmployeeDetails(HttpServletRequest req) {

		Student employee = employeeDelegator.getEmployee(req.getParameter("id"));

		return new ModelAndView("home", "msg", employee);
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute Student sb) {

		Student addEmployee = employeeDelegator.addEmployee(sb);

		return new ModelAndView("Success", "student", addEmployee);
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute Student sb) {

		Student updateEmployee = employeeDelegator.updateEmployee(sb);

		return new ModelAndView("Success", "student", updateEmployee);
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	public ModelAndView deleteStudent(HttpServletRequest req) {

		String deleteEmployee = employeeDelegator.deleteEmployee(req.getParameter("id"));

		return new ModelAndView("Success", "student", deleteEmployee);
	}

	@RequestMapping("/getAllStudents")
	public ModelAndView getAllStudents() {

		List<Student> allStudent = employeeDelegator.getAllStudent();

		return new ModelAndView("viewEmployee", "listStudent", allStudent);
	}
}
