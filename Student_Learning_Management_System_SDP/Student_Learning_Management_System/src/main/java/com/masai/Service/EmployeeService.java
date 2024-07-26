package com.masai.Service;

import java.util.List;

import com.masai.Exception.EmployeeException;
import com.masai.Model.Employee;


public interface EmployeeService {

	public Employee AddEmployee(Employee employee)throws EmployeeException;
	public Employee getEmployeeById(int id)throws EmployeeException;
	public List<Employee> getAllEmployees()throws EmployeeException;
	public Employee UpdateEmployee(Employee employee,int id)throws EmployeeException;
	public Employee DeleteEmployee(Employee employee,int id)throws EmployeeException;
	
}
