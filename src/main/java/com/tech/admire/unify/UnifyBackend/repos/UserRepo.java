package com.tech.admire.unify.UnifyBackend.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.admire.unify.UnifyBackend.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

	// Find by email
	Optional<User> findByEmail(String email);

	// Find all active students
	List<User> findByIsActive(boolean isActive);

}