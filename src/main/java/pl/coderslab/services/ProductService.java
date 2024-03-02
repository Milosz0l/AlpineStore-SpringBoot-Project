package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entities.Product;
import pl.coderslab.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public void updateProduct(int id, Product updatedProduct) {
        updatedProduct.setPid(id);
        productRepository.save(updatedProduct);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Product getProductByPname(String name) {
        return productRepository.findByPname(name);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
