package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Student;
import com.book.entity.Teacher;
import com.book.service.TeacherService;

@RestController
@RequestMapping("/api")
public class TeacherController {
	private TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	
	@PostMapping("/add/teacher")
	public Teacher registerTeacher(@RequestBody Teacher teacher) {
		return teacherService.addTeacher(teacher);
	}
	
	@PostMapping("/add/student")
	public Student registerStudent(@RequestBody Student student) {
		return teacherService.addStudent(student);
	}
	
	@GetMapping("/allstudent")
	public List<Student> getStud(){
		return teacherService.getStuds();
	}
	
	@GetMapping("/all")
	public List<Teacher> allTeacher(){
		return teacherService.allTeacher();
	}
}
