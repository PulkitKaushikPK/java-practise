package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByProductId(Long userId);

	List<Product> findAllByOrderByPriceAsc();

	List<Product> findByPriceGreaterThan(Long price);

	List<Product> findAllByOrderByRatingsDesc();
	


}
