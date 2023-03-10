package com.multiplex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.UserDTO;
import com.multiplex.entities.User;
import com.multiplex.exception.UserAlreadyExistsException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.repository.UserRepository;
import com.multiplex.services.UserServices;

@RestController
@ResponseBody
public class UserController {

	@Autowired
	private UserServices userServices;
	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping(value="/usertable")
	public ResponseEntity<List<UserDTO>> getUsers() throws UserNotFoundException{
		List<UserDTO> userList=userServices.getUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
//	 @PostMapping("/logins")
//	    public ResponseEntity<String> loginUser(@RequestBody User user) {
//	        try {
//	            String token = userServices.loginUser(user);
//	            return ResponseEntity.ok(token);
//	        } catch (UserNotFoundException e) {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//	        }
//	    }

	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
	    	User loginUser = UserRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());

	        if (loginUser != null) {
	            session.setAttribute("username", user.getUserName());
	            return ResponseEntity.ok().body("Logged in successfully!");
	        } else {
	            return ResponseEntity.badRequest().body("Incorrect username or password!");
	        }
	    }
	
	// Post mapping request for registering the user and his/her details
	@PostMapping(value="/usertable")
	public ResponseEntity<String> addUser(@RequestBody UserDTO user) throws UserAlreadyExistsException{
		userServices.addUser(user);
		return new ResponseEntity<>("API.INSERT_CREATED", HttpStatus.CREATED);
	}

@GetMapping(value="/usertable/{userId}")
public ResponseEntity<UserDTO> getUserbyId(@PathVariable Integer userId) throws UserNotFoundException{
	UserDTO user=userServices.getUserById(userId);
	return new ResponseEntity<>(user, HttpStatus.OK);
}


@DeleteMapping(value="/usertable/{userId}")
public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) throws UserNotFoundException{
	userServices.deleteUser(userId);
	return new ResponseEntity<>("API.DELETE_SUCCESS", HttpStatus.OK);
}


//@GetMapping("/usertable/u/{userName}")
//public ResponseEntity<List> getUserByName(@PathVariable String userName) throws UserNotFoundException{
//	return new ResponseEntity<>(userServices.getUserByName(userName), HttpStatus.FOUND);
//}

@PutMapping(value="/usertable/u/{userId}")
public ResponseEntity<String> updateUserByEmailId(@PathVariable Integer userId, @RequestBody UserDTO user) throws UserNotFoundException{
	userServices.updateUserByEmailId(userId, user.getEmailId());
	return new ResponseEntity<>("Updated Successfully", HttpStatus.ACCEPTED);
}
}
