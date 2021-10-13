package com.shopify.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopify.DTOs.ProductsDTO;
import com.shopify.Models.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Long>{

	Vendor findByEmailId(String emailId);
	
//	@Query("select new com.shopify.DTOs.ProductsDTO(p.pdtName, p.qty, p.price) from Vendor v join v.products p")
//	List<ProductsDTO> getProductsOfShop(long id);

}
