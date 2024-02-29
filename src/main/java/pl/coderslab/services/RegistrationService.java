package pl.coderslab.services;

import pl.coderslab.entities.User;
import pl.coderslab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService; // Dodaj zależność

    public void registerUser(User user) {
        // Szyfrowanie hasła użytkownika przed zapisaniem go do bazy danych
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        // Tutaj można dodać logikę walidacji lub inne operacje przed zapisaniem użytkownika

        userRepository.save(user); // Zapisanie użytkownika do bazy danych

        // Wyślij wiadomość e-mail powitalną
        emailService.sendWelcomeEmail(user.getUserEmail());
    }
}