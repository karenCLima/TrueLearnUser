package com.TrueLearn.User.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Where;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor 
@NoArgsConstructor
@Where(clause = "active = true")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID userID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "birthdayDate")
	private LocalDateTime birthdayDate;
	
	@Column(name = "registerDate")
	private LocalDateTime registerDate;
	
	@Column(name = "gender") 
	private  Gender gender;
	
	@Column(name = "state") 
	private  String state;
	
	@Column(name= "password")
	private String password;
	
	@Column(name = "active")
	private boolean active;
}
