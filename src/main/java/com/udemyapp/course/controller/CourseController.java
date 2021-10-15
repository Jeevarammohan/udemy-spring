package com.udemyapp.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemyapp.course.model.Course;
import com.udemyapp.course.service.CourseService;

/**
 * @author JeevaR
 *
 */
@RestController
@RequestMapping("/udemy-api")
public class CourseController {
	@Autowired
	CourseService courseService;

	@PostMapping("/courses/instructors/{instructorId}/create")
	ResponseEntity<Course> addCourse(@RequestBody Course course,@PathVariable("instructorId") Integer instructorId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course is created");
		Course nCourse = courseService.addCourse(course,instructorId);
		return ResponseEntity.ok().headers(headers).body(nCourse);
	}

	@DeleteMapping("/courses/courseid/{courseId}")
	ResponseEntity<String> deleteCourse(@PathVariable("courseId") Integer courseId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course is deleted");
		courseService.deleteCourse(courseId);
		String response="Course is deleted";
		return ResponseEntity.ok().headers(headers).body(response);
	}

	@PutMapping("/courses")
	ResponseEntity<Void> updateCourse(@RequestBody Course course) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course is updated");
		courseService.updateCourse(course);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/courses")
	ResponseEntity<List<Course>> getAllCourses() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "all course are retrieved");
		List<Course> allCourses = courseService.getAllCourses();
		return ResponseEntity.ok().headers(headers).body(allCourses);
	}

	@GetMapping("/courses/{courseId}")
	ResponseEntity<Course> getById(@PathVariable("courseId") Integer courseId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course is retrieved");
		Course nCourse = courseService.getById(courseId);
		return ResponseEntity.ok().headers(headers).body(nCourse);
	}

	@GetMapping("/courses/category/{category}")
	ResponseEntity<List<Course>> getByCategory(@PathVariable("category") String category) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course are retrieved by category");
		List<Course> coursesByCategory = courseService.getByCategory(category);
		return ResponseEntity.ok().headers(headers).body(coursesByCategory);
	}

	@GetMapping("/courses/category/{category}/price/{price}")
	ResponseEntity<List<Course>> getByCategoryAndPrice(@PathVariable("category") String category,
			@PathVariable("price") double price) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course are retrieved by category and price");
		List<Course> coursesByCategoryAndPrice = courseService.getByCategoryAndPrice(category, price);
		return ResponseEntity.ok().headers(headers).body(coursesByCategoryAndPrice);
	}

	@GetMapping("/courses/category/{category}/rating/{rating}")
	ResponseEntity<List<Course>> getByCategoryAndRating(@PathVariable("category") String category,
			@PathVariable("rating") double rating) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course are retrieved by category and rating");
		List<Course> coursesByCategoryAndRating = courseService.getByCategoryAndRating(category, rating);
		return ResponseEntity.ok().headers(headers).body(coursesByCategoryAndRating);
	}

	@GetMapping("/courses/category/{category}/duration/{duration}")
	ResponseEntity<List<Course>> getByCategoryAndDuration(@PathVariable("category") String category,
			@PathVariable("duration") double duration) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course are retrieved by category and duration");
		List<Course> coursesByCategoryAndDuration = courseService.getByCategoryAndDuration(category, duration);
		return ResponseEntity.ok().headers(headers).body(coursesByCategoryAndDuration);
	}

	@GetMapping("/courses/category/{category}/discount/{discount}")
	ResponseEntity<List<Course>> getByCategoryAndDiscount(@PathVariable("category") String category,
			@PathVariable("discount") double discount) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course are retrieved by category and discount");
		List<Course> coursesByCategoryAndDiscount = courseService.getByCategoryAndDiscount(category, discount);
		return ResponseEntity.ok().headers(headers).body(coursesByCategoryAndDiscount);
	}

}
