package com.tgd.pcs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgd.pcs.entity.Product;
import com.tgd.pcs.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		log.debug("fetching getAllProducts");
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		log.debug("fetching getProductById");
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/category/{category}")
	public List<Product> getProductsByCategory(@PathVariable String category) {
		return productService.getProductsByCategory(category);
	}

	@GetMapping("/search")
	public List<Product> searchProducts(@RequestParam String name) {
		return productService.searchProductsByName(name);
	}

	@GetMapping("/price")
	public List<Product> getProductsByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
		return productService.getProductsByPriceRange(minPrice, maxPrice);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(id, product);
		return updatedProduct != null ? ResponseEntity.ok(updatedProduct)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
	
	@PostMapping("/getProductsByIds")
	public List<Product> getProductsByIds(@RequestBody List<Long> ids) {
		return productService.getAllByIds(ids);
	}
}
