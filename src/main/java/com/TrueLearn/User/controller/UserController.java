package com.TrueLearn.User.controller;

import java.net.URI;
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

import com.TrueLearn.User.dto.UserRequest;
import com.TrueLearn.User.dto.UserResponse;
import com.TrueLearn.User.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping()
	public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
		UserResponse user = userService.saveUser(userRequest);
		return ResponseEntity.created(URI.create("/user/"+user.getUserId())).body(user);
	}
	
	@GetMapping()
	public ResponseEntity<List<UserResponse>> getUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@DeleteMapping("/{cpf}")
	public void deleteCustomer(@PathVariable String cpf){
		userService.deleteUser(cpf);
	}
	
	@PutMapping()
	public ResponseEntity<UserResponse> updateCustomer(
			@RequestBody UserRequest userRequest
			){
		return ResponseEntity.ok(userService.updateUser(userRequest));
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<UserResponse> getUserByCpf(@PathVariable String cpf){
		return ResponseEntity.ok(userService.getUserByCpf(cpf));
	}

}
