package pl.coderslab.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.coderslab.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>
{
public Admin findByadminEmail(String email);


}
