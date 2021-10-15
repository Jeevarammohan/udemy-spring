package com.udemyapp.student.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.udemyapp.course.model.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author JeevaR
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(generator = "student_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "student_gen", schema = "student_seq", initialValue = 1, allocationSize = 1)
	private Integer studentId;
	private String name;
	private String paymentMethod;
	private double credits;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Set<PurchaseHistory> histories;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private Set<Course> courseList;

	public Student(String name, String paymentMethod, double credits) {
		super();
		this.name = name;
		this.paymentMethod = paymentMethod;
		this.credits = credits;
	}

	public void setCourseList(Course course) {
		courseList.add(course);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", paymentMethod=" + paymentMethod + ", credits="
				+ credits + ", histories=" + histories + "]";
	}


}
