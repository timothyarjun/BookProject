package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Student;
import com.book.entity.Teacher;
import com.book.repository.SchoolRepo;
import com.book.repository.StudentRepo;
import com.book.repository.TeacherRepo;

@Service
public class TeacherService {
	private SchoolRepo schoolRepo;
	private TeacherRepo teacherRepo;
	private StudentRepo studentRepo;
	
	@Autowired
	public TeacherService(TeacherRepo teacherRepo, StudentRepo studentRepo,SchoolRepo schoolRepo) {
		super();
		this.teacherRepo = teacherRepo;
		this.studentRepo = studentRepo;
		this.schoolRepo	 = schoolRepo;
	}
	
	public Teacher addTeacher(Teacher teacher) {
	//	teacher.getStudents().getClass();
		return teacherRepo.save(teacher);
	}

	public Student addStudent(Student student) {
		student.setTeacher(teacherRepo.getOne(student.getTeacher_id()));
		return studentRepo.save(student);
	}

	public List<Student> getStuds() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	public List<Teacher> allTeacher() {
		// TODO Auto-generated method stub
		return teacherRepo.findAll();
	}
}
