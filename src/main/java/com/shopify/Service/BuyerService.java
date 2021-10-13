package com.shopify.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.DTOs.pdtDTO;
import com.shopify.DTOs.shopsName;
import com.shopify.Models.Buyer;
import com.shopify.Models.Products;
import com.shopify.Models.Vendor;
import com.shopify.Repository.BuyerRepo;
import com.shopify.Repository.VendorRepo;

@Service
public class BuyerService {
	@Autowired
	private BuyerRepo buyerRepo;
	@Autowired
	private VendorRepo vendorRepo;

	public Buyer fetchByEmailId(String emailId) {
		return buyerRepo.findByEmailId(emailId);
	}

	public Buyer registerBuyer(Buyer buyer) {
		return buyerRepo.save(buyer);
	}

	public List<shopsName> fetchShopsByCity(int pin) {
		return vendorRepo.findByPinNum(pin);
	}

	public List<pdtDTO> fetchByPdt(int pin, String product) {
		 List<Vendor> list = vendorRepo.findByPin(pin);
		 List<pdtDTO> ans = new ArrayList<>();
		 for(Vendor shop : list) {
			 List<Products> pdtList = shop.getProducts();
			 for(Products pdt : pdtList) {
				 if(pdt.getPdtName().equals(product)) {
					 pdtDTO obj = new pdtDTO(shop.getShopName(), shop.getArea(), shop.getProducts());
					 ans.add(obj); 
				 }
			 }
		 }
		 return ans;
	}
	
}
