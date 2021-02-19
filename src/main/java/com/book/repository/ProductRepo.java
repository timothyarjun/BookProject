package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
