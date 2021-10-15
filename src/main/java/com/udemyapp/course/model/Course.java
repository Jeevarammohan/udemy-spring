package com.udemyapp.course.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemyapp.instructor.model.Instructor;
import com.udemyapp.student.model.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(generator = "course_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen", schema = "course_seq", initialValue = 1010, allocationSize = 1)
	private Integer courseId;
	private String name;
	private String category;
	private double price;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Description description;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	@ManyToMany(mappedBy = "courseList")
	@JsonIgnore
	private Set<Student> studentList = new HashSet<Student>();
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", description=" + description + "]";
	}
	

	

}
