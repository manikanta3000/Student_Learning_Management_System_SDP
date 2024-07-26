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

import com.masai.Exception.StudentException;
import com.masai.Model.Student;
import com.masai.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student>  addStudent(@RequestBody Student student)throws StudentException{
		Student st = studentservice.AddStudent(student);
		return new ResponseEntity<>(st,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id)throws StudentException{
		
		Student stu = studentservice.getStudentById(id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents()throws StudentException{
		List<Student> list = studentservice.getAllStudents();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id)throws StudentException{
		Student stu = studentservice.UpdateStudent(student, id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteStudent/{id}")
	public ResponseEntity<Student> DeleteStudent(Student student,@PathVariable int id)throws StudentException{
		Student stu = studentservice.DeleteStudent(student, id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
		
	}
	
}
