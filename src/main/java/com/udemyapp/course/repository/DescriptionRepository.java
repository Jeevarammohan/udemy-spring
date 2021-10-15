package com.udemyapp.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemyapp.course.model.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Integer> {

}
