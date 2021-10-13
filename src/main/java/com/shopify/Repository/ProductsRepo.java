package com.shopify.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopify.DTOs.ProductsDTO;
import com.shopify.Models.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long>{
	
}	
