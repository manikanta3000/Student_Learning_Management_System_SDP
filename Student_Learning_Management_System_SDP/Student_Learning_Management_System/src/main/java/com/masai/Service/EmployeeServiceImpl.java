package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.EmployeeException;
import com.masai.Model.Employee;
import com.masai.Repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	public EmployeeRepository employeerepository;
	
	@Override
	public Employee AddEmployee(Employee employee) throws EmployeeException {
		return employeerepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
    Optional<Employee> employee = employeerepository.findById(id);
		
		if(employee.isEmpty()) {
			throw new EmployeeException("No employee exists with id : "+id);
		}
		
		return employee.get();
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
List<Employee> list = employeerepository.findAll();
		
		return list;
	}

	@Override
	public Employee UpdateEmployee(Employee employee, int id) throws EmployeeException {
Optional<Employee> emp = employeerepository.findById(id);
		
		if(emp.isEmpty()) {
			throw new EmployeeException("No employee exists with id : "+id);
		}
		
		Employee stud = emp.get();
		stud.setName(employee.getName());
		stud.setEmail(employee.getEmail());
		stud.setRole(employee.getRole());
		stud.setSalary(employee.getSalary());
		return employeerepository.save(stud);
	}

	@Override
	public Employee DeleteEmployee(Employee employee, int id) throws EmployeeException {
Optional<Employee> stu = employeerepository.findById(id);
		
		if(stu.isEmpty()) {
			throw new EmployeeException("No employee exists with id : "+id);
		}
		 Employee stud = stu.get();
		 employeerepository.delete(stud);
		 return stud;
	}

}
