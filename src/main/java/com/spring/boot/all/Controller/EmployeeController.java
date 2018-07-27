package com.spring.boot.all.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boot.all.Dao.EmployeeDao;
import com.spring.boot.all.bean.EmployeeBean;
import com.spring.boot.all.entity.Employee;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeDao dao;

	@PostMapping(value = "/save/insert", consumes = "application/json", produces = "application/json")
	public void insertdata(@RequestBody EmployeeBean emp) {

		System.out.println("Inserted....");
		dao.savethedata(emp);

	}

	public EmployeeController() {
		super();
		System.out.println("IN THE CONTROLLER.....");

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public void deletedata(int emp) {
		System.out.println("Deleted...");

		dao.deletetheemp(emp);

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Employee updatedata(Employee emp) {
		System.out.println("Deleted...");

		return dao.updateEmployee(emp);

	}

	@RequestMapping(value = "/getall/{eid}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public Optional<Employee> getid(@PathVariable("eid") Integer eid) {

		System.out.println("Your details are:::" + eid);

		return dao.getthedatabyid(eid);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getall() {

		List<Employee> li = dao.getalldata();
		System.out.println(li.size());
		System.out.println("The list of date is::::");
		return li;
	}

}
