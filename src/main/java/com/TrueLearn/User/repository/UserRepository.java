package com.TrueLearn.User.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TrueLearn.User.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	@Query(value = "SELECT * FROM USERS WHERE CPF = :userCpf", nativeQuery = true)
    User findByCpf(String userCpf);

}
