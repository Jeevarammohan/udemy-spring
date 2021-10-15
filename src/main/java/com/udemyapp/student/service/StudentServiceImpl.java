package com.udemyapp.student.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemyapp.course.model.Course;
import com.udemyapp.course.service.CourseService;
import com.udemyapp.exception.StudentNotFoundException;
import com.udemyapp.student.model.PurchaseHistory;
import com.udemyapp.student.model.Student;
import com.udemyapp.student.repository.StudentRepository;

/**
 * @author JeevaR
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseService courseService;
	@Autowired
	PurchaseHistoryService historyService;
	@Override
	public Student register(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteAccount(Integer studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public void updateAccount(Student student) {
		studentRepository.save(student);
	}

	@Override
	public Student getById(Integer studentId) throws StudentNotFoundException {
		Student student =studentRepository.findById(studentId).get();
		if (student == null) {
			throw new StudentNotFoundException("Invalid id");
		}
		System.out.println(student);
		return student;
		
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public String enrollCourse(Integer studentId, Integer courseId) {
		Course course=courseService.getById(courseId);
		Student student=studentRepository.getById(studentId);
		student.setCourseList(course);
		updateAccount(student);
		//studentRepository.save(student);
		PurchaseHistory history=new PurchaseHistory();
		history.setCourseName(course.getName());
		history.setPaymentType(student.getPaymentMethod());
		history.setPrice(course.getPrice());
		history.setPurchaseDate(LocalDate.now());
		history.setStudent(student);
		historyService.addPurchaseHistory(history);
		return "Added course : "+course;
	}

}
