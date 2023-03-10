package com.example.sbjsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbjsp.entities.User;
import com.example.sbjsp.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User insert(User user){
		return userRepository.save(user);
	}
	
	public Optional<User> findById(Long id){
		return userRepository.findById(id);
	}
	
	public void delete(User user){
		 userRepository.delete(user);
	}
}
