package com.org.schoolsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.schoolsystem.entities.Role;
import com.org.schoolsystem.entities.User;
import com.org.schoolsystem.repositories.RoleRepository;
import com.org.schoolsystem.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//method to create users
	public User createUser(User user) {
		
		encodeUserPassword(user);
		return userRepository.save(user);
	}
	
	//method to list all users
	public List<User> listAllUsers(){
		
		return userRepository.findAll();
	}
	
	//method to list all roles
	public List<Role> listAllRoles() {
		return roleRepository.findAll();
	}
	//method to get user by id
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	//method to encrypt user password
	public void encodeUserPassword(User user) {
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		
	}
	
}
