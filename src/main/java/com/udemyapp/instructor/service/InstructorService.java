package com.udemyapp.instructor.service;

import java.util.List;

import com.udemyapp.exception.InstructorNotFoundException;
import com.udemyapp.instructor.model.Instructor;

public interface InstructorService {

	Instructor register(Instructor instructor);

	void deleteAccount(Integer instructorId);

	void updateAccount(Instructor instructor);

	Instructor getById(Integer instructorId) throws InstructorNotFoundException;

	List<Instructor> getAllInstructors();
}
