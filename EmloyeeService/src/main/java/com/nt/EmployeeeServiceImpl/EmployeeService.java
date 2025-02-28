package com.nt.EmployeeeServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.IEmloyeeService.IEmployeeService;
import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;
@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository repo;

	@Override
	public String addEmployee(Employee e) {
		Employee savedEmployee=repo.save(e);
		return "Employee saved successfully with id:"+e.getEmpId();

	}

	@Override
	public Employee findEmployeeById(int id) throws Exception {
		Optional<Employee> opt=repo.findById(id);
		System.out.println(opt.get());
		
	Employee e=opt.orElseThrow(()-> new Exception());
	
	return e;

	}

	@Override
	public List<Employee> findAllEmployes() {
		return repo.findAll();

	}

	@Override
	public String updateEmployee(Employee e) throws Exception {
		Employee e1=findEmployeeById(e.getEmpId());
		if(e1!=null) {
		repo.save(e);
		
		}
		
		return "Employee Updateed";

	}

	@Override
	public String deleteEmloyee(int id) throws Exception {
		Employee e=findEmployeeById(id);
		if(e!=null)
		repo.deleteById(id);
		
		return "Employee Deleted";

	}

	
}
