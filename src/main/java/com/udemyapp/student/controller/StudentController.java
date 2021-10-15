package com.udemyapp.student.controller;

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

import com.udemyapp.student.model.Student;
import com.udemyapp.student.service.StudentService;

/**
 * @author JeevaR
 *
 */
@RestController
@RequestMapping("/udemy-api")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	public ResponseEntity<Student> register(@RequestBody Student student) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "student is registered");
		Student nStudent = studentService.register(student);
		return ResponseEntity.ok().headers(headers).body(nStudent);

	}

	@DeleteMapping("/students/studentid/{studentId}")
	public ResponseEntity<Void> deleteAccount(@PathVariable("studentId") Integer studentId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "student account is deleted");
		studentService.deleteAccount(studentId);
		return ResponseEntity.ok().headers(headers).build();
	}

	@PutMapping("/students")
	public ResponseEntity<Void> updateAccount(@RequestBody Student student) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "student detail is updated");
		studentService.updateAccount(student);
		return ResponseEntity.ok().headers(headers).build();

	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "student detail is retrieved");
		Student student = null;
		System.out.println("Hello");
		student=studentService.getById(studentId);
		return ResponseEntity.ok().headers(headers).body(student);

	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "student detail is retrieved");
		List<Student> studentList = studentService.getAllStudents();
		return ResponseEntity.ok().headers(headers).body(studentList);

	}
	
	@GetMapping("/students/id/{studentId}/courses/{courseId}/enroll")
	public ResponseEntity<Void> enrollCourse(@PathVariable("studentId") Integer studentId,@PathVariable("courseId") Integer courseId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "course is enrolled to student");
		System.out.println("controller");
		studentService.enrollCourse(studentId,courseId);
		return ResponseEntity.ok().headers(headers).build();

	}

	
}
