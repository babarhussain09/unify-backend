package com.tech.admire.unify.UnifyBackend.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.admire.unify.UnifyBackend.entities.Application;
import com.tech.admire.unify.UnifyBackend.entities.User;
import com.tech.admire.unify.UnifyBackend.repos.ApplicationRepo;
import com.tech.admire.unify.UnifyBackend.repos.UserRepo;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepo applicationRepository;

	@Autowired
	private UserRepo userRepository;

	// Add a new application
	public Application addApplication(Long userId, Application application) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			application.setCreationTime(LocalDateTime.now());
			application.setUser(user.get());
			return applicationRepository.save(application);
		} else {
			throw new Exception("User not found");
		}
	}

	// Update an existing application
	public Application updateApplication(Long applicationId, Application updatedApplication) throws Exception {
		Optional<Application> existingApplication = applicationRepository.findById(applicationId);
		if (existingApplication.isPresent()) {
			Application application = existingApplication.get();
			application.setUniversityName(updatedApplication.getUniversityName());
			application.setCourseName(updatedApplication.getCourseName());
			return applicationRepository.save(application);
		} else {
			throw new Exception("Application not found");
		}
	}

	// Delete an application
	public void deleteApplication(Long applicationId) throws Exception {
		Optional<Application> application = applicationRepository.findById(applicationId);
		if (application.isPresent()) {
			applicationRepository.delete(application.get());
		} else {
			throw new Exception("Application not found");
		}
	}

	// Get applications for a specific user
	public List<Application> getApplicationsForUser(Long userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return applicationRepository.findByUserId(userId);
		} else {
			throw new Exception("User not found");
		}
	}
}
