package com.redishash.dao;

import java.util.Map;

import com.redishash.model.Student;

public interface StudentDao {
	
	void addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(Integer id);
	Student getOneStudent(Integer Id);
	Map<Integer, Student> getAllStudent();
	

}
