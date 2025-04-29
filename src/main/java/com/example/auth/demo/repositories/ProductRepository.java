package com.example.auth.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.demo.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}