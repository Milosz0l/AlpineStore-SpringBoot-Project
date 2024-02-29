package pl.coderslab.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.coderslab.entities.User;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUserEmail(String userEmail);




}