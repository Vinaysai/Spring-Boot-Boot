package com.spring.boot.all.Dao;

import java.util.List;
import java.util.Optional;

import com.spring.boot.all.bean.EmployeeBean;
import com.spring.boot.all.entity.Employee;

public interface EmployeeDao {

	Employee savethedata(EmployeeBean emp);

	List<Employee> getalldata();

	Optional<Employee> getthedatabyid(Integer eid);

	Employee updateEmployee(Employee emp);

	void deletetheemp(int emp);

}