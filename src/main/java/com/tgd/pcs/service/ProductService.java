package com.tgd.pcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgd.pcs.entity.Product;
import com.tgd.pcs.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	public List<Product> getProductsByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
		return productRepository.findByPriceBetween(minPrice, maxPrice);
	}

	public List<Product> searchProductsByName(String name) {
		return productRepository.findByNameContainingIgnoreCase(name);
	}

	public Product updateProduct(Long id, Product updatedProduct) {
		if (productRepository.existsById(id)) {
			updatedProduct.setId(id);
			return productRepository.save(updatedProduct);
		}
		return null;
	}
	
	public Product createProduct(Product product) {
        return productRepository.save(product);	
    }
	
	public List<Product> getAllByIds(List<Long> ids){
		return productRepository.findAllById(ids);
	}
}
