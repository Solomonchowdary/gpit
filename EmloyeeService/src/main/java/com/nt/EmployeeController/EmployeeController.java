package com.nt.EmployeeController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Bindings.EmployeeInputs;
import com.nt.IEmloyeeService.IEmployeeService;
import com.nt.entity.Employee;

@RestController
@RequestMapping("/emp-service-api")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmp(@RequestBody EmployeeInputs inp){
		Employee e=new Employee();
		System.out.println(inp.getDept());
		BeanUtils.copyProperties(inp, e);
		String result=service.addEmployee(e);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<EmployeeInputs> getEmp(@PathVariable int id) throws Exception{
		
	Employee e=service.findEmployeeById(id);
	EmployeeInputs ei=new EmployeeInputs();
	BeanUtils.copyProperties(e, ei);
	System.out.println(ei);
	
	return new ResponseEntity<EmployeeInputs>(ei,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<EmployeeInputs>> getAllEmployees(){
		List<Employee> list=service.findAllEmployes();
		List<EmployeeInputs> ei=new ArrayList<EmployeeInputs>();
		for(Employee e:list) {
			EmployeeInputs e1=new EmployeeInputs();
			BeanUtils.copyProperties(e, e1);
			ei.add(e1);
			System.out.println(e1);
		}
		
		
		return new ResponseEntity<List<EmployeeInputs>>(ei,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeInputs inp) throws Exception{
		System.out.println("EmployeeController.updateEmployee()");
		Employee e=new Employee();
		BeanUtils.copyProperties(inp, e);
		System.out.println(e);
		String res=service.updateEmployee(e);
		System.out.println(res);
		
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int  id) throws Exception {
	return 	service.deleteEmloyee(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
