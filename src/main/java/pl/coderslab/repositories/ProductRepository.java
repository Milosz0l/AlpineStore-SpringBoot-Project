package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import pl.coderslab.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByPname(String name);
}