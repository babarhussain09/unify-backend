package com.tech.admire.unify.UnifyBackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tech.admire.unify.UnifyBackend.entities.User;
import com.tech.admire.unify.UnifyBackend.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Register a new user
	public User registerUser(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	// Login with email and password
	public User loginUser(String email, String password) throws Exception {
		Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
			return user.get();
		} else {
			throw new Exception("Invalid email or password");
		}
	}

	// Get all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Add a new user (admin functionality)
	public User addUser(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	// Update an existing user
	public User updateUser(Long userId, User updatedUser) throws Exception {
		Optional<User> existingUser = userRepository.findById(userId);
		if (existingUser.isPresent()) {
			User user = existingUser.get();

			// Update all fields
			user.setFirstName(updatedUser.getFirstName());
			user.setLastName(updatedUser.getLastName());
			user.setEmail(updatedUser.getEmail());
			user.setPhoneNumber(updatedUser.getPhoneNumber());
			user.setGender(updatedUser.getGender());
			user.setDateOfBirth(updatedUser.getDateOfBirth());
			user.setGuardianName(updatedUser.getGuardianName());
			user.setNationality(updatedUser.getNationality());
			user.setAddress(updatedUser.getAddress());

			// Handle password encoding, if needed
			if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
				// Assuming passwordEncoder is available in the class
				String encodedPassword = passwordEncoder.encode(updatedUser.getPassword());
				user.setPassword(encodedPassword);
			}

			return userRepository.save(user); // Save and return updated user
		} else {
			throw new Exception("User not found");
		}
	}

	// Delete a user
	public void deleteUser(Long userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			userRepository.delete(user.get());
		} else {
			throw new Exception("User not found");
		}
	}
}
