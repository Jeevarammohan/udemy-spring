package com.udemyapp.course.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemyapp.course.model.Description;
import com.udemyapp.course.repository.DescriptionRepository;

/**
 * @author JeevaR
 *
 */
@Service
public class DescriptionServiceImpl implements DescriptionService {

	@Autowired
	DescriptionRepository descriptionRepository;

	@Override
	public Description addDescription(Description description) {
		return descriptionRepository.save(description);
	}

	@Override
	public void deleteDescription(Integer descriptionId) {
		descriptionRepository.deleteById(descriptionId);
	}

	@Override
	public void updateDescription(Description description) {
		descriptionRepository.save(description);
	}

	@Override
	public Description getById(Integer descriptionId) {
		return descriptionRepository.findById(descriptionId).get();
	}

}
