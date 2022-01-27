package com.java;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.java.models.Product;
import com.java.repository.ProductRepository;
import com.java.service.ProductService;




@SpringBootTest
class UserProductServiceApplicationTests {

	@MockBean
	ProductRepository repository;
	
	@Autowired
	ProductService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getProductsTest() {
		
		when(repository.findAll()).thenReturn(Stream
				.of(new Product(376L, "Danile", "31", 200L,1L,2L),new Product(376L, "Danile", "31", 200L,1L,2L)).collect(Collectors.toList()));
		assertThat(service.getProducts().getBody().toString().length()).isGreaterThan(0);
	}
	
	@Test
	public void saveProductTest() {
		Product p=new Product(376L, "Danile", "31", 200L,1L,2L);
		when(repository.save(p)).thenReturn(p);
		assertThat(service.saveProduct(p).toString().length()).isGreaterThan(0);
		
	}
	
//	@Test
//	public void getSortedProductsTest() {
//		Product p=new Product(376L, "Danile", "31", 200L,1L,2L);
//		List<Product> p1= new ArrayList<>();
//		p1.add(p);
//		p1.add(p);
//		ResponseEntity<Object> s=p1.toString();
//		 new ResponseEntity<>("Hi","Hello");
//		when(service.sortProductByPrice()).thenReturn(new ResponseEntity<Object>("Hi","Hello");
//		  assertThat(p.size()).isGreaterThan(0);
//		
//	}
//	
//	@Test
//	public void getSortedProductsByRatingTest() {
//		
//		when(repository.findAll()).thenReturn(Stream
//				.of(new Product(376L, "Danile", "31", 200L,1L,2L),new Product(376L, "Danile", "31", 200L,1L,2L)).collect(Collectors.toList()));
//		assertThat(service.sortProductByRating().getBody().toString().length()).isGreaterThan(0);
//	}
	
	


	
	
	

}
