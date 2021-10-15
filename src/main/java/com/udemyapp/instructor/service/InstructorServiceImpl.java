package com.udemyapp.instructor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemyapp.exception.InstructorNotFoundException;
import com.udemyapp.instructor.model.Instructor;
import com.udemyapp.instructor.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorRepository instructorRepository;

	@Override
	public Instructor register(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@Override
	public void deleteAccount(Integer instructorId) {
		instructorRepository.deleteById(instructorId);
	}

	@Override
	public void updateAccount(Instructor instructor) {
		instructorRepository.save(instructor);
	}

	@Override
	public List<Instructor> getAllInstructors() {
		return instructorRepository.findAll();
	}

	@Override
	public Instructor getById(Integer instructorId) throws InstructorNotFoundException {
		Instructor instructor = null;
		instructor = instructorRepository.findById(instructorId).get();
		if (instructor == null) {
			throw new InstructorNotFoundException("Invalid id");
		}
		return instructor;
	}

}
