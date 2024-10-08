package com.tech.admire.unify.UnifyBackend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.admire.unify.UnifyBackend.entities.Application;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
	List<Application> findByUserId(Long userId);
}