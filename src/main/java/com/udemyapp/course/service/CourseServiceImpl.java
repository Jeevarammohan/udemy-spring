package com.udemyapp.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemyapp.course.model.Course;
import com.udemyapp.course.repository.CourseRepository;
import com.udemyapp.exception.CourseNotFoundException;
import com.udemyapp.instructor.model.Instructor;
import com.udemyapp.instructor.repository.InstructorRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	InstructorRepository instructorRepository;

	@Override
	public Course addCourse(Course course,Integer instructorId) {
		Instructor instructor=instructorRepository.findById(instructorId).get();
		course.setInstructor(instructor);
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourse(Integer courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	@Override
	public Course getById(Integer courseId) throws CourseNotFoundException {
		Course course = null;
		course = courseRepository.findById(courseId).get();
		if (course == null) {
			throw new CourseNotFoundException("Invalid Id");
		}
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public List<Course> getByCategory(String category) throws CourseNotFoundException {
		List<Course> coursesByCategory = courseRepository.findByCategory(category);
		if (coursesByCategory.isEmpty()) {
			throw new CourseNotFoundException("Category Not Found");
		}
		return coursesByCategory;
	}

	@Override
	public List<Course> getByCategoryAndPrice(String category, double price) throws CourseNotFoundException {
		List<Course> coursesByCategoryAndPrice = courseRepository.findByCategoryAndPriceLessThan(category, price);
		if (coursesByCategoryAndPrice.isEmpty()) {
			throw new CourseNotFoundException("Category or Price Not Found");
		}
		return coursesByCategoryAndPrice;
	}

	@Override
	public List<Course> getByCategoryAndRating(String category, double rating) throws CourseNotFoundException {
		List<Course> coursesByCategoryAndRating = courseRepository.findByCategoryAndRating(category, rating);
		if (coursesByCategoryAndRating.isEmpty()) {
			throw new CourseNotFoundException("Category or Rating Not Found");
		}
		return coursesByCategoryAndRating;
	}

	@Override
	public List<Course> getByCategoryAndDuration(String category, double duration) throws CourseNotFoundException {
		List<Course> coursesByCategoryAndDuration = courseRepository.findByCategoryAndDuration(category, duration);
		if (coursesByCategoryAndDuration.isEmpty()) {
			throw new CourseNotFoundException("Category or Duration Not Found");
		}
		return coursesByCategoryAndDuration;
	}

	@Override
	public List<Course> getByCategoryAndDiscount(String category, double discount) throws CourseNotFoundException {
		List<Course> coursesByCategoryAndDiscount = courseRepository.findByCategoryAndDiscount(category, discount);
		if (coursesByCategoryAndDiscount.isEmpty()) {
			throw new CourseNotFoundException("Category or Discount Not Found");
		}
		return coursesByCategoryAndDiscount;
	}

}
