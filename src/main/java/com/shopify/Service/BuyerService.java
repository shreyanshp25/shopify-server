package com.shopify.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.DTOs.shopsName;
import com.shopify.Models.Buyer;
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
		return vendorRepo.findByPin(pin);
	}
	
}
