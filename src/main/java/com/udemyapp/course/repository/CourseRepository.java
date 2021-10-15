package com.udemyapp.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udemyapp.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	List<Course> findByCategory(String category);

	List<Course> findByCategoryAndPriceLessThan(String category, double price);

	@Query("From Course c inner join c.description d where c.category=?1 and d.rating<=?2")
	List<Course> findByCategoryAndRating(String category, double rating);

	@Query("From Course c inner join c.description d where c.category=?1 and d.duration<=?2")
	List<Course> findByCategoryAndDuration(String category, double duration);

	@Query("From Course c inner join c.description d where c.category=?1 and d.discount<=?2")
	List<Course> findByCategoryAndDiscount(String category, double discount);
}
