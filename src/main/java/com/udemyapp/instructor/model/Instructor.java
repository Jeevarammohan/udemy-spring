package com.udemyapp.instructor.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.udemyapp.course.model.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Instructor {

	@Id
	@GeneratedValue(generator = "instructor_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "instructor_gen", schema = "instructor_seq", initialValue = 1, allocationSize = 1)
	private Integer instructorId;
	private String name;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Course> courseList;

	public Instructor(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", name=" + name + "]";
	}

	

	
	
	
	

}
