package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Product;
import pl.coderslab.services.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addingProduct")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/services";
    }

    @GetMapping("/updateProduct/{productId}")
    public String updateProductForm(@PathVariable("productId") int id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + id));
        model.addAttribute("product", product);
        return "update-product-form";
    }

    @PostMapping("/updatingProduct/{productId}")
    public String updateProduct(@PathVariable("productId") int id, @ModelAttribute Product updatedProduct) {
        productService.updateProduct(id, updatedProduct);
        return "redirect:/services";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") int id) {
        productService.deleteProduct(id);
        return "redirect:/services";
    }
}
