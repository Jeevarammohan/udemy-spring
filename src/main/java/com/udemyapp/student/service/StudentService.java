package com.udemyapp.student.service;

import java.util.List;

import com.udemyapp.exception.StudentNotFoundException;
import com.udemyapp.student.model.Student;

/**
 * @author JeevaR
 *
 */
public interface StudentService {

	Student register(Student student);

	void deleteAccount(Integer studentId);

	void updateAccount(Student student);

	Student getById(Integer studentId) throws StudentNotFoundException;

	List<Student> getAllStudents();
	
	String enrollCourse(Integer studentId,Integer couseId);

}
