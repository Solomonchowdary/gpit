package com.nt.IEmloyeeService;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeService {
	
	public String addEmployee(Employee e);
	public Employee findEmployeeById(int id) throws Exception;
	public List<Employee> findAllEmployes();
	
	public String deleteEmloyee(int id) throws Exception;
	public String updateEmployee(Employee e) throws Exception;

}
