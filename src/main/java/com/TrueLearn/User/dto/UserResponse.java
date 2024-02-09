package com.TrueLearn.User.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.TrueLearn.User.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	private UUID userId;
	
	private String name;
	
	private String cpf;
	
	private String email;
	
	private LocalDateTime birthdayDate;
	
	private LocalDateTime registerDate;
	 
	private  Gender gender;
	
	private String state;
	
	

}
