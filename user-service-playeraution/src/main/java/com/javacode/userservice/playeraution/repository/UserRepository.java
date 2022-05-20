package com.javacode.userservice.playeraution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacode.userservice.playeraution.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserNameAndPassword(String userName, String password);

}
