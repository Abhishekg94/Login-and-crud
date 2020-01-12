package com.vikash.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vikash.modal.User;
import com.vikash.repository.UserRepository;

//import antlr.collections.List;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	public void saveMyUser(User user) {

		userRepository.save(user);
	}
	
	public List<User> showAllUsers(){
		List<User> users = new ArrayList<User>();
		for(User user: userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}
 
	public void deleteMyUser(int id) {
		userRepository.deleteById(id);
	}
	
	public Optional<User> editUser(int id) {
	return	userRepository.findById(id);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		System.out.println("user name: "+username+" password: "+password);
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
