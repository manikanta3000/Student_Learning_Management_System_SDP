package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.EmployeeException;
import com.masai.Model.Employee;
import com.masai.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee>  addEmployee(@RequestBody Employee employee)throws EmployeeException{
		Employee st = employeeservice.AddEmployee(employee);
		return new ResponseEntity<>(st,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)throws EmployeeException{
		
		Employee stu = employeeservice.getEmployeeById(id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()throws EmployeeException{
		List<Employee> list = employeeservice.getAllEmployees();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable int id)throws EmployeeException{
		Employee stu = employeeservice.UpdateEmployee(employee, id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteEmployee/{id}")
	public ResponseEntity<Employee> DeleteEmployee(Employee employee,@PathVariable int id)throws EmployeeException{
		Employee stu = employeeservice.DeleteEmployee(employee, id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
		
	}
	
}
