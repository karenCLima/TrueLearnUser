package com.TrueLearn.User.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrueLearn.User.dto.UserRequest;
import com.TrueLearn.User.dto.UserResponse;
import com.TrueLearn.User.model.User;
import com.TrueLearn.User.repository.UserRepository;
import com.TrueLearn.User.util.UserConvert;
import com.TrueLearn.User.util.Validator;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserResponse saveUser(UserRequest userRequest) {
		User user = UserConvert.toEntity(userRequest);
		user.setRegisterDate(LocalDateTime.now());
		long age = user.getBirthdayDate().until(LocalDateTime.now(), ChronoUnit.YEARS);
		if(age < 18) throw new RuntimeException("You must be 18 years old to register");
		if(!Validator.passwordValidate(user.getPassword())) throw new RuntimeException("Senha deve seguir o padrao:\n -1 Letra  maíuscula,\n -1 letra minuscula,\n -1 numero,\n -1 caractere especial,\n -tamanho mínimo de 8 carcteres");
		user.setActive(true);
		return UserConvert.toResponse(userRepository.save(user));
		
	}
	
	public List<UserResponse> getAllUsers(){
		List<User> users = userRepository.findAll();
		return UserConvert.toResponseList(users);
	}
	
	public UserResponse updateUser(UserRequest userRequest) {
		User user = UserConvert.toEntity(userRequest);
		User existUser = userRepository.findByCpf(user.getCpf());
		if(existUser == null) throw new RuntimeException("User not Found!");
		user.setUserID(existUser.getUserID());
		user.setRegisterDate(existUser.getRegisterDate());
		user.setActive(true);
		return UserConvert.toResponse(userRepository.save(user));
	}
	
	public void deleteUser(String cpf) {
		User existUser = userRepository.findByCpf(cpf);
		if(existUser == null) throw new RuntimeException("User not found!");
		existUser.setActive(false);
		userRepository.save(existUser);
	}
	
	public UserResponse getUserByCpf(String cpf) {
		User existUser = userRepository.findByCpf(cpf);
		if(existUser == null) throw new RuntimeException("User not Found!");
		return UserConvert.toResponse(existUser);
	}

}
