package pl.coderslab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.User;
import pl.coderslab.repositories.UserRepository;

@Component
public class UserService
{
	@Autowired
	private UserRepository userRepository;

////	public static String setPassword(String email, String newPassword) {
//		User user = userRepository.findByUserEmail(email)
//				.orElseThrow(() -> new RuntimeException("User not found" + email));
//		user.setPassword(newPassword);
//		UserRepository.save(user);
//		return "new password set succesfully";
//	}
//
//	public  String forgotPassword(String email) {
//		User user = userRepository.findByUserEmail(email)
//				.orElseThrow(() -> new RuntimeException("User not found" + email));
//		EmailService.sendSetPassword(email);
//		return "check emial";
//	}

	//Get All Users
	public List<User> getAllUser()
	{
		List<User> users = (List<User>) this.userRepository.findAll();
		return users;
	}

	//Get Single User
	public User getUser(int id)
	{
		Optional<User> optional = this.userRepository.findById(id);
		User user = optional.get();
		return user;
	}

	//Update
	public void updateUser(User user,int id)
	{
		user.setUserId(id);
		this.userRepository.save(user);
	}

	//delete single User
	public void deleteUser(int id)
	{
		this.userRepository.deleteById(id);
	}

	//Add User
	public void addUser(User user)
	{
		this.userRepository.save(user);
	}


}