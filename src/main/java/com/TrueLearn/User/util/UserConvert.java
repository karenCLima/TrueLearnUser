package com.TrueLearn.User.util;

import java.util.List;
import java.util.ArrayList;

import com.TrueLearn.User.dto.UserRequest;
import com.TrueLearn.User.dto.UserResponse;
import com.TrueLearn.User.model.User;

public class UserConvert {
	
	public static User toEntity(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setCpf(userRequest.getCpf());
		user.setEmail(userRequest.getEmail());
		user.setBirthdayDate(userRequest.getBirthdayDate());
		user.setGender(userRequest.getGender());
		user.setPassword(userRequest.getPassword());
		user.setState(userRequest.getState());
		
		return user;
	}
	
	public static UserResponse toResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setName(user.getName());
		userResponse.setUserId(user.getUserID());
		userResponse.setCpf(user.getCpf());
		userResponse.setEmail(user.getEmail());
		userResponse.setBirthdayDate(user.getBirthdayDate());
		userResponse.setRegisterDate(user.getRegisterDate());
		userResponse.setGender(user.getGender());
		userResponse.setState(user.getState());
		
		return userResponse;
		
	}
	
	public static List<UserResponse> toResponseList(List<User> users){
		List<UserResponse> userResponses = new ArrayList<>();
		for (User user : users) {
			UserResponse userResponse = UserConvert.toResponse(user);
			userResponses.add(userResponse);
		}
		
		return userResponses;
	}

}
