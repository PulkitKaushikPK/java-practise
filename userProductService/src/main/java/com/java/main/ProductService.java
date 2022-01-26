package com.java.main;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	 @Autowired
	  private ProductRepository productRepository;
	 
	 public ResponseEntity<Object> saveProduct(Product user) {
		 Product newUser=productRepository.save(user);
	     return new ResponseEntity<>(newUser,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> getProductById(Long id) {	     
		 Product user=productRepository.getById(id);
	       return new ResponseEntity<>(user,HttpStatus.OK);
	    }

	public ResponseEntity<Object> getProducts() {
		List<Product> allProducts= productRepository.findAll();
		
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}

	public ResponseEntity<Object> sortProductByPrice() {
		List<Product> allProducts= productRepository.findAllByOrderByPriceAsc();
		System.out.println("sorted are: "+ allProducts);
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	public ResponseEntity<Object> sortProductByRating() {
		List<Product> allProducts= productRepository.findAllByOrderByRatingsDesc();
		System.out.println("sorted are: "+ allProducts);
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}

	public ResponseEntity<Object> filterProductByPrice(Long price) {
		List<Product> filteredByPrice=productRepository.findByPriceGreaterThan(price);
		return new ResponseEntity<>(filteredByPrice,HttpStatus.OK);

	}
	
	public ResponseEntity<Object> getQuantityById(Long id) {
		Optional<Product> product= productRepository.findById(id);
		return new ResponseEntity<>(product.get().getMaxQuantity(),HttpStatus.OK);

	}

}
