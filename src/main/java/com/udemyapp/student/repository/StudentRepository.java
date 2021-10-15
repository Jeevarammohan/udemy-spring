package com.udemyapp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemyapp.student.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
