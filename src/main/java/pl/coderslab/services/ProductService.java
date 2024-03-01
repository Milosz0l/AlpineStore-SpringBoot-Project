package pl.coderslab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Product;
import pl.coderslab.repositories.ProductRepository;

@Component
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;

	public void addProduct(Product p)
	{
		this.productRepository.save(p);
	}

	public List<Product>getAllProducts()
	{
		List<Product> products = (List<Product>) this.productRepository.findAll();
		return products;
	}

	public Product getProduct(int id)
	{
		Optional<Product> optional = this.productRepository.findById(id);
		Product product=optional.get();
		return product;
	}
	public void updateproduct(Product p,int id)
	{
		p.setPid(id);
		Optional<Product> optional = this.productRepository.findById(id);
		Product prod=optional.get();
		if(prod.getPid()==id)
		{
			this.productRepository.save(p);
		}
	}
	public void deleteProduct(int id)
	{
		this.productRepository.deleteById(id);
	}
}
