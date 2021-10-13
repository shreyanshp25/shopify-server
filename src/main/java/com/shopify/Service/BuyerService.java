package com.shopify.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.Models.Buyer;
import com.shopify.Repository.BuyerRepo;

@Service
public class BuyerService {
	@Autowired
	private BuyerRepo buyerRepo;

	public Buyer fetchByEmailId(String emailId) {
		return buyerRepo.findByEmailId(emailId);
	}

	public Buyer registerBuyer(Buyer buyer) {
		return buyerRepo.save(buyer);
	}
	
}
