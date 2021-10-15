package com.udemyapp.course.controller;

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

import com.udemyapp.course.model.Description;
import com.udemyapp.course.service.DescriptionService;

/**
 * @author JeevaR
 *
 */
@RestController
@RequestMapping("/udemy-api")
public class DescriptionController {

	@Autowired
	DescriptionService descriptionService;

	@PostMapping("/descriptions")
	ResponseEntity<Description> addDescription(@RequestBody Description description) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "description is created");
		Description nDescription = descriptionService.addDescription(description);
		return ResponseEntity.ok().headers(headers).body(nDescription);
	}

	@DeleteMapping("/descriptions/descriptionid/{descriptionId}")
	ResponseEntity<Void> deleteDescription(@PathVariable("descriptionId") Integer descriptionId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "description is deleted");
		descriptionService.deleteDescription(descriptionId);
		return ResponseEntity.ok().headers(headers).build();
	}

	@PutMapping("/descriptions")
	ResponseEntity<Void> updateDescription(@RequestBody Description description) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "description is updated");
		descriptionService.updateDescription(description);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/descriptions/{descriptionId}")
	ResponseEntity<Description> getById(@PathVariable("descriptionId") Integer descriptionId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "description is retrieved");
		Description nDescription = descriptionService.getById(descriptionId);
		return ResponseEntity.ok().headers(headers).body(nDescription);
	}
}
