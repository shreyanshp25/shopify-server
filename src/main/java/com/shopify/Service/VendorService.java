package com.shopify.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopify.DTOs.ProductsDTO;
import com.shopify.Exceptions.ResourceNotFound;
import com.shopify.Models.Products;
import com.shopify.Models.Vendor;
import com.shopify.Repository.ProductsRepo;
import com.shopify.Repository.VendorRepo;

@Service
public class VendorService {
	@Autowired
	private VendorRepo vendorRepo;
	@Autowired
	private ProductsRepo pdtRepo;
	
	public Vendor fetchByEmailId(String emailId) {
		return vendorRepo.findByEmailId(emailId);
	}

	public Vendor saveVendor(Vendor vendor) {
		return vendorRepo.save(vendor);
	}

	public Vendor addProduct(Vendor vendor) {
		Vendor obj = vendorRepo.findByEmailId(vendor.getEmailId());
		obj.setProducts(vendor.getProducts());
		vendorRepo.save(obj);
		return obj;
	}

	public List<Products> getPdtsById(long id) {
		Vendor obj = vendorRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User Doesn't exist"));
		List<Products> pdtObj = obj.getProducts();
		return pdtObj;
	}

	public ResponseEntity<Vendor> fetchById(long id) {
		Vendor obj = vendorRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User Doesn't exist"));
		return ResponseEntity.ok(obj);
	}

	public Products fetchPdtById(long id) {
		return pdtRepo.findBypdtId(id);
	}
	
}
