package com.TrueLearn.User.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.TrueLearn.User.model.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	
	@NotEmpty @Length(min = 3)
	private String name;
	
	@CPF
	private String cpf;
	
	@Email
	private String email;
	
	@NotNull
	private LocalDateTime birthdayDate;
	 
	private  Gender gender;
	
	private String state;
	
	@NotEmpty @Length(min = 8)
	private String password;
}
