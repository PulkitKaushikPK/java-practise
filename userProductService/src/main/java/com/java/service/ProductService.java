package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.java.exceptions.InvalidRequestBodyException;
import com.java.exceptions.NoDataFoundException;
import com.java.exceptions.ResourceNotFoundException;
import com.java.models.Product;
import com.java.models.ProductModel;
import com.java.repository.ProductRepository;

@Service
public class ProductService {

	 @Autowired
	  private ProductRepository productRepository;
	 
	 public ResponseEntity<Object> saveProduct(Product product) {
		 
		 if(product==null) {
			 throw new InvalidRequestBodyException("Enter valid request body");
		 }
		 
		 if(isNullOrEmpty(product.getName())) {
			 throw new InvalidRequestBodyException("Product name is missing ");
		 }
		 
		 Product newProduct=productRepository.save(product);
	     return new ResponseEntity<>(newProduct,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> getProductById(Long id) throws Exception {
			
		 if(!productRepository.existsById(id)) {
			 throw new ResourceNotFoundException("There is no product with id: "+ id);

		 }
		 Product user=productRepository.findById(id).get();

		 
	       return new ResponseEntity<>(user,HttpStatus.OK);
	    }

	public ResponseEntity<Object> getProducts() {
		List<Product> allProducts= productRepository.findAll();
		
		if(allProducts.isEmpty()) {
			throw new NoDataFoundException("No products are available");
		}
		
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}

	public ResponseEntity<Object> sortProductByPrice() {
		List<Product> sortedProducts= productRepository.findAllByOrderByPriceAsc();
		
		if(sortedProducts.isEmpty()) {
			throw new NoDataFoundException("No products are available");
		}
		
		System.out.println("sorted are: "+ sortedProducts);
		return new ResponseEntity<>(sortedProducts,HttpStatus.OK);
	}
	
	public ResponseEntity<Object> sortProductByRating() {
		List<Product> sortedProductsByRatings= productRepository.findAllByOrderByRatingsDesc();
		
		if(sortedProductsByRatings.isEmpty()) {
			throw new NoDataFoundException("No products are available");
		}
		
		return new ResponseEntity<>(sortedProductsByRatings,HttpStatus.OK);
	}

	public ResponseEntity<Object> filterProductByPrice(Long price) {
		List<Product> filteredByPrice=productRepository.findByPriceGreaterThan(price);
		
		if(filteredByPrice.isEmpty()) {
			throw new NoDataFoundException("No products are available");
		}
		return new ResponseEntity<>(filteredByPrice,HttpStatus.OK);

	}
	
	public ResponseEntity<Object> getQuantityById(Long id) {
		Optional<Product> product= productRepository.findById(id);
		
		if(!productRepository.existsById(id)) {
			 throw new ResourceNotFoundException("There is no product with id: "+ id);

		 }
		return new ResponseEntity<>(product.get().getMaxQuantity(),HttpStatus.OK);

	}

	//Updating the product 
	public ResponseEntity<Object> getUpdateQuantity(Long pId, Long quantity) {
		Product prod=productRepository.findByProductId(pId);
		
		if(!productRepository.existsById(pId)) {
			 throw new ResourceNotFoundException("There is no product with id: "+ pId);

		 }
		prod.setMaxQuantity(prod.getMaxQuantity()-quantity);
		productRepository.save(prod);
		return new ResponseEntity<>(prod,HttpStatus.OK);

	}
	
	public boolean isNullOrEmpty(String value) {
		if(value != null && !"".equals(value)) {
			return false;
		}
		else {
			return true;
		}
	}

}
