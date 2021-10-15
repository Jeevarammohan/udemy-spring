package com.udemyapp.instructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemyapp.instructor.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
