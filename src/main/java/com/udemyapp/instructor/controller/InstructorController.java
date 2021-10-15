package com.udemyapp.instructor.controller;

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

import com.udemyapp.instructor.model.Instructor;
import com.udemyapp.instructor.service.InstructorService;

/**
 * @author JeevaR
 *
 */
@RestController
@RequestMapping("/udemy-api")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@PostMapping("/instructors")
	ResponseEntity<Instructor> register(@RequestBody Instructor instructor) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "instructor is registered");
		Instructor nInstructor = instructorService.register(instructor);
		return ResponseEntity.ok().headers(headers).body(nInstructor);
	}

	@DeleteMapping("/instructors/instructorid/{instructorId}")
	ResponseEntity<String> deleteAccount(@PathVariable("instructorId") Integer instructorId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "instructor account is deleted");
		instructorService.deleteAccount(instructorId);
		return ResponseEntity.ok().headers(headers).body("Instructor is deleted");
	}

	@PutMapping("/instructors")
	ResponseEntity<Void> updateAccount(@RequestBody Instructor instructor) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "instructor details are updated");
		instructorService.updateAccount(instructor);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/instructors/{instructorId}")
	ResponseEntity<Instructor> getById(@PathVariable("instructorId") Integer instructorId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "instructor is retrieved");
		Instructor nInstructor = instructorService.getById(instructorId);
		return ResponseEntity.ok().headers(headers).body(nInstructor);
	}

	@GetMapping("/instructors")
	ResponseEntity<List<Instructor>> getAllInstructors() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All instructors is retrieved");
		List<Instructor> instructorsList = instructorService.getAllInstructors();
		return ResponseEntity.ok().headers(headers).body(instructorsList);
	}
}
