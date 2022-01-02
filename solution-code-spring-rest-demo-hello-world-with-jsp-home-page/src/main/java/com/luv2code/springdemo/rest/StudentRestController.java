package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@RequestMapping("/students")
	public List<Student> getStudents(){
		
		List<Student>students=new ArrayList<Student>();
		students.add(new Student("Mohamed","Ahmed"));
		students.add(new Student("Spring","Course") );
		
		
		return students;
	}

}
