package com.tech.admire.unify.UnifyBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.admire.unify.UnifyBackend.entities.Application;
import com.tech.admire.unify.UnifyBackend.services.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Add a new application for a user
    @PostMapping("/user/{userId}")
    public ResponseEntity<Application> addApplication(@PathVariable Long userId, @RequestBody Application application) {
        try {
            Application newApplication = applicationService.addApplication(userId, application);
            return ResponseEntity.ok(newApplication);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Update an existing application
    @PutMapping("/{applicationId}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long applicationId, @RequestBody Application updatedApplication) {
        try {
            Application updated = applicationService.updateApplication(applicationId, updatedApplication);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete an application
    @DeleteMapping("/{applicationId}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long applicationId) {
        try {
            applicationService.deleteApplication(applicationId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all applications for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Application>> getApplicationsForUser(@PathVariable Long userId) {
        try {
            List<Application> applications = applicationService.getApplicationsForUser(userId);
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
