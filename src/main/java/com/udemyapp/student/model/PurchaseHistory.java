package com.udemyapp.student.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class PurchaseHistory {

	@Id
	@GeneratedValue(generator = "purchaseH_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "purchaseH_gen", schema = "purchaseH_seq", initialValue = 100, allocationSize = 1)
	private Integer puchaseId;
	private String courseName;
	@Column(name = "purchaseDate")
	private LocalDate purchaseDate;
	private double price;
	@Column(name = "paymentType")
	private String paymentType;
	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;

	public PurchaseHistory(String courseName, LocalDate purchaseDate, double price, String paymentType,
			Student student) {
		super();
		this.courseName = courseName;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.paymentType = paymentType;
		this.student = student;
	}

	@Override
	public String toString() {
		return "PurchaseHistory [puchaseId=" + puchaseId + ", courseName=" + courseName + ", purchaseDate="
				+ purchaseDate + ", price=" + price + ", paymentType=" + paymentType + "]";
	}

	
	

}
