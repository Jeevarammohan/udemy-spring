package com.udemyapp.course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Description {

	@Id
	@GeneratedValue(generator = "description_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "description_gen", schema = "description_seq", initialValue = 1, allocationSize = 1)
	private Integer descriptionId;
	private double rating;
	private double duration;
	private double discount;
	private String language;

	@OneToOne
	@JoinColumn(name = "course_id")
	@JsonIgnore
	private Course course;

	public Description(double rating, double duration, double discount, String language) {
		super();
		this.rating = rating;
		this.duration = duration;
		this.discount = discount;
		this.language = language;
	}

	@Override
	public String toString() {
		return "Description [rating=" + rating + ", duration=" + duration + ", discount=" + discount + ", language="
				+ language + "]";
	}

}
