package com.udemyapp.course.service;

import java.util.List;

import com.udemyapp.course.model.Course;
import com.udemyapp.exception.CourseNotFoundException;

public interface CourseService {

	Course addCourse(Course course,Integer instructorId);

	void deleteCourse(Integer courseId);

	void updateCourse(Course course);

	Course getById(Integer courseId) throws CourseNotFoundException;

	List<Course> getAllCourses();

	List<Course> getByCategory(String category) throws CourseNotFoundException;

	List<Course> getByCategoryAndPrice(String category, double price) throws CourseNotFoundException;

	List<Course> getByCategoryAndRating(String category, double rating) throws CourseNotFoundException;

	List<Course> getByCategoryAndDuration(String category, double duration) throws CourseNotFoundException;

	List<Course> getByCategoryAndDiscount(String category, double discount) throws CourseNotFoundException;

}
