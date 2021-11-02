package com.moglix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moglix.dto.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
