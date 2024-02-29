package pl.coderslab.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.coderslab.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>
{
	public Product findByPname(String name);

}
