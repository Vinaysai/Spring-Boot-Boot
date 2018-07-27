package com.spring.boot.all.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.all.bean.EmployeeBean;
import com.spring.boot.all.entity.Employee;
import com.spring.boot.all.repository.EmployeeRepository;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	public EmployeeRepository employeeRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.boot.all.Dao.EmployeeDao#savethedata(com.spring.boot.all.entity.
	 * Employee)
	 */
	@Override
	public Employee savethedata(EmployeeBean emp) {

		Employee empl = new Employee();
		empl.setId(emp.getId());
		empl.setName(emp.getName());
		empl.setTelephone(emp.getTelephone());
		empl.setEmail(emp.getEmail());
		empl.setAddress(emp.getAddress());

		return employeeRepository.save(empl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.boot.all.Dao.EmployeeDao#getalldata()
	 */
	@Override
	public List<Employee> getalldata() {

		return employeeRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.boot.all.Dao.EmployeeDao#deletetheemp(com.spring.boot.all.entity.
	 * Employee)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.boot.all.Dao.EmployeeDao#getthedatabyid(java.lang.Integer)
	 */
	@Override
	public Optional<Employee> getthedatabyid(Integer eid) {

		return employeeRepository.findById(eid);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.boot.all.Dao.EmployeeDao#updateEmployee(com.spring.boot.all.entity
	 * .Employee)
	 */
	@Override
	public Employee updateEmployee(Employee emp) {
		System.err.println(getthedatabyid(emp.getId()).isPresent());
		if (!getthedatabyid(emp.getId()).isPresent())
			System.out.println("Updation failed");
		return employeeRepository.save(emp);
	}

	@Override
	public void deletetheemp(int emp) {

		employeeRepository.deleteById(emp);

	}

}
