package com.udemyapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemyapp.course.service.CourseService;
import com.udemyapp.course.service.DescriptionService;
import com.udemyapp.instructor.service.InstructorService;
import com.udemyapp.student.service.PurchaseHistoryService;
import com.udemyapp.student.service.StudentService;

@SpringBootApplication
public class SpringUdemyappRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringUdemyappRestapiApplication.class, args);
	}

	@Autowired
	StudentService studentService;
	@Autowired
	PurchaseHistoryService purchaseHistoryService;
	@Autowired
	CourseService courseService;

	@Autowired
	DescriptionService descriptionService;

	@Autowired
	InstructorService instructorService;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(studentService.getById(2));
//		System.out.println(studentService.enrollCourse(2, 1010));
//		Instructor instructor = new Instructor("Maya");
//		System.out.println(instructorService.register(instructor));
//		Course course1 = new Course("Microservice", "Web", 6000, instructor);
//		Description description1 = new Description(4.7, 5.5, 23.0, "ENG", course1);
//		System.out.println(descriptionService.addDescription(description1));
//		System.out.println(courseService.addCourse(course1, 1));
//		Course course2 = new Course("Javascript", "Web", 5000, instructor);
//		Description description2 = new Description(4.8, 6.5, 33.0, "ENG", course2);
//		System.out.println(descriptionService.addDescription(description2));
//		System.out.println(courseService.addCourse(course2, 1));
//		Course course3 = new Course("HTML", "Web", 2000, instructor);
//		Description description3 = new Description(4.5, 2.5, 13.0, "ENG", course3);
//		System.out.println(descriptionService.addDescription(description3));
//		System.out.println(courseService.addCourse(course3, 1));
//		Course course4 = new Course("MicrCSSoservice", "Web", 2000, instructor);
//		Description description4 = new Description(4.0, 1.5, 27.0, "ENG", course4);
//		System.out.println(descriptionService.addDescription(description4));
//		System.out.println(courseService.addCourse(course4, 1));
////		Set<Course> courseSet = new HashSet<>(
////				Arrays.asList(courseService.getById(1010), courseService.getById(1012), courseService.getById(1013)));
//		Student student = new Student("Jeeva", "Debit-card", 100);
//		System.out.println(studentService.register(student));
//		PurchaseHistory purchaseHistory = new PurchaseHistory("HTML", LocalDate.now(), 2000, "Debit-card", student);
//		System.out.println(purchaseHistoryService.addPurchaseHistory(purchaseHistory));
//		Credential credential = new Credential("jeeva@gmail.com", "1232434", "student", student, new Instructor());
//		Credential credential1 = new Credential("maya@gmail.com", "2345", "instructor", new Student(), instructor);
//		credentialService.addCredential(credential);
//		credentialService.addCredential(credential1);

	}

}
