package com.tgd.pcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgd.pcs.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByCategory(String category);

	List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

	List<Product> findByNameContainingIgnoreCase(String name);
}
