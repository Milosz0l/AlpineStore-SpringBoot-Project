package pl.coderslab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.User;
import pl.coderslab.repositories.UserRepository;

@Component
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public List<User> getAllUser() {
        List<User> users = (List<User>) this.userRepository.findAll();
        return users;
    }

    public User getUser(int id) {
        Optional<User> optional = this.userRepository.findById(id);
        User user = optional.get();
        return user;
    }

    public void updateUser(User user, int id) {
        user.setUserId(id);
        this.userRepository.save(user);
    }

    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }


}