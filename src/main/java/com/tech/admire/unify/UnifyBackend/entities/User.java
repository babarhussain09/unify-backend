package com.tech.admire.unify.UnifyBackend.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user", schema = "unify_backend")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	private String firstName;
	private String lastName;
	private String guardianName;
	private String gender;
	private LocalDate dateOfBirth;
	private String nationality;
	private String address;
	private String phoneNumber;

	private boolean isActive;

	// One student can have many applications
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private List<Application> applications;

}
