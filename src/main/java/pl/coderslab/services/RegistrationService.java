package pl.coderslab.services;

import pl.coderslab.entities.User;
import pl.coderslab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    private final UserRepository userRepository;


    private final BCryptPasswordEncoder passwordEncoder;


    private final EmailService emailService;

    @Autowired
    public RegistrationService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public void registerUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userRepository.save(user);
        emailService.sendWelcomeEmail(user.getUserEmail());
    }
}