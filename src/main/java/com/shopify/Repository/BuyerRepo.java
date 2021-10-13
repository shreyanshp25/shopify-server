package com.shopify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopify.Models.Buyer;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Long> {

	Buyer findByEmailId(String emailId);

}
