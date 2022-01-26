package com.java.main;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByProductId(Long userId);

	List<Product> findAllByOrderByPriceAsc();

	List<Product> findByPriceGreaterThan(Long price);

	List<Product> findAllByOrderByRatingsDesc();
	


}
