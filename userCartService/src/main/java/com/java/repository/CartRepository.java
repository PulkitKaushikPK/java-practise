package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart getByUserId(Long id);

	Cart getByCartId(Long id);

	
}
