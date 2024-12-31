package com.tgd.pcs.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
    private Long id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "description")
    private String description;
	
	 @Column(name = "price",nullable = false, precision = 10, scale = 2)
	 private BigDecimal price;
	
	@Column(name = "available", nullable = false)
    private Boolean available;
	
	@Column(name = "category", nullable = false)
    private String category;
	
	@Column(name = "image_url")
    private String imageUrl;

}
