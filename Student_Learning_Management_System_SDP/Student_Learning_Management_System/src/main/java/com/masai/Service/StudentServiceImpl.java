package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.StudentException;
import com.masai.Model.Student;
import com.masai.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	public StudentRepository studentrepository;
	
	@Override
	public Student AddStudent(Student student) throws StudentException {
		return studentrepository.save(student);
	}

	@Override
	public Student getStudentById(int id) throws StudentException {
		
		Optional<Student> student = studentrepository.findById(id);
		
		if(student.isEmpty()) {
			throw new StudentException("No student exists with id : "+id);
		}
		
		return student.get();
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		
		List<Student> list = studentrepository.findAll();
		
		return list;
	}

	@Override
	public Student UpdateStudent(Student student, int id) throws StudentException {
		
		Optional<Student> stu = studentrepository.findById(id);
		
		if(stu.isEmpty()) {
			throw new StudentException("No student exists with id : "+id);
		}
		
		Student stud = stu.get();
		stud.setName(student.getName());
		stud.setEmail(student.getEmail());
		stud.setPhone(student.getPhone());
		
		return studentrepository.save(stud);
	}

	@Override
	public Student DeleteStudent(Student student, int id) throws StudentException {
		
        Optional<Student> stu = studentrepository.findById(id);
		
		if(stu.isEmpty()) {
			throw new StudentException("No student exists with id : "+id);
		}
		 Student stud = stu.get();
		 studentrepository.delete(stud);
		 return stud;
	}

}
