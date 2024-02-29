package pl.coderslab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.entities.Product;
import pl.coderslab.repositories.ProductRepository;

@Controller
public class UserController 
{
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/userlogin")
	public String allProduct(Model model)
	{
		List<Product>product=(List<Product>) productRepository.findAll();
		model.addAttribute("products", product);
		return "All_Product";
	}
 @GetMapping("/selecting")
 public String selectedProduct()
 {
	 return "Product_Selected";
 }

}

//@PutMapping("/forgotPassword")
//public ResponseEntity<String> forgotPassword(@RequestParam String email) {
//	return new ResponseEntity<>(UserService.forgotPassword(email), HttpStatus.OK);
//}
//
//@PutMapping("/setPassword")
//public ResponseEntity<String> setPassword(@RequestParam String email, @RequestParam String newPassword) {
//	return new ResponseEntity<>(UserService.setPassword(email, newPassword), HttpStatus.OK);
//}
