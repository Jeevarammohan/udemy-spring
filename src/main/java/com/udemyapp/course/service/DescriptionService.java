package com.udemyapp.course.service;

import com.udemyapp.course.model.Description;

/**
 * @author JeevaR
 *
 */
public interface DescriptionService {

	Description addDescription(Description description);

	void deleteDescription(Integer descriptionId);

	void updateDescription(Description description);

	Description getById(Integer descriptionId);
}
