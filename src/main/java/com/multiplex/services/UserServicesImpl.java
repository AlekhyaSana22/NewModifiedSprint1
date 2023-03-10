package com.multiplex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.UserDTO;
import com.multiplex.entities.User;
import com.multiplex.exception.UserAlreadyExistsException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.repository.UserRepository;
@Service(value="userservice")

public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepository userRepository;
	@Override
	public List<UserDTO> getUsers() throws UserNotFoundException{
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> users2 = new ArrayList<>();
		users.forEach(user ->{
		UserDTO user1=new UserDTO();
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		user1.setEmailId(user.getEmailId());
		user1.setPassword(user.getPassword());
		user1.setPhoneNumber(user.getPhoneNumber());
		users2.add(user1);
		});
		if(users2.isEmpty()) {
			throw new UserNotFoundException();
		}
		return users2;

	}
	@Override
	public User addUser(UserDTO userDto) throws UserAlreadyExistsException{
		if(userRepository.findByEmailId(userDto.getEmailId()).isEmpty()) {
		User userEntity=new User();
		userEntity.setUserId(userDto.getUserId());
		userEntity.setUserName(userDto.getUserName());
		userEntity.setEmailId(userDto.getEmailId());
		userEntity.setPassword(userDto.getPassword());
		userEntity.setPhoneNumber(userDto.getPhoneNumber());
		return userRepository.save(userEntity);
		}
		else {
		throw new UserAlreadyExistsException();
		}
	}
	@Override
	public UserDTO getUserById(Integer userId) throws UserNotFoundException{
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(UserNotFoundException::new);
		UserDTO user2=new UserDTO();
		user2.setUserId(user.getUserId());
		user2.setUserName(user.getUserName());
		user2.setEmailId(user.getEmailId());
		user2.setPassword(user.getPassword());
		user2.setPhoneNumber(user.getPhoneNumber());
		return user2;
	}
	@Override
	public void deleteUser(Integer userId) throws UserNotFoundException{
		Optional<User> optional = userRepository.findById(userId);
		User user=optional.orElseThrow(UserNotFoundException::new);
		UserDTO user2=new UserDTO();
		user2.setUserId(user.getUserId());
		user2.setUserName(user.getUserName());
		user2.setEmailId(user.getEmailId());
		user2.setPassword(user.getPassword());
		user2.setPhoneNumber(user.getPhoneNumber());
		userRepository.deleteById(userId);
	}
//	@Override
//	public List<UserDTO> getUserByName(String userName) throws UserNotFoundException{
//		Iterable<User> users = userRepository.findUserByName(userName);
//		List<UserDTO> users2 = new ArrayList<>();
//		users.forEach(user ->{
//		UserDTO user1=new UserDTO();
//		user1.setUserId(user.getUserId());
//		user1.setUserName(user.getUserName());
//		user1.setEmailId(user.getEmailId());
//		user1.setPassword(user.getPassword());
//		user1.setPhoneNumber(user.getPhoneNumber());
//		users2.add(user1);
//		});
//		if(users2.isEmpty()) {
//			throw new UserNotFoundException();
//		}
//return users2;
//}
	@Override
	public void updateUserByEmailId(Integer userId, String emailId) throws UserNotFoundException {
		if(userRepository.existsById(userId)) {
			User user=userRepository.findById(userId).get();
			user.setEmailId(emailId);
			userRepository.save(user);
		}
		else {
			throw new UserNotFoundException();
		}
	}
//	//check the login by validating both the email id and password
//		public String loginUser(User user) throws UserNotFoundException {
//			if(UserRepository.validateUser(user.getEmailId(),user.getPassword()).isEmpty())
//				{
//					throw new UserNotFoundException("Invalid User");
//				}
//			return "Login Successful";
//		}

	    @Override
	    public boolean findByUserNameAndPassword(String userName, String password) {
	        User user = userRepository.findByUserName(userName);
	        if (user != null && user.getPassword().equals(password)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    // Other methods for user registration, logout, etc.
	    // ...
	}

		
//		@Override
//		public User findByEmailAndPassword(String emailId, String password) {
//	        return userRepository.findByEmailAndPassword(emailId, password);
//		}




