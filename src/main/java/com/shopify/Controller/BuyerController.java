package com.shopify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.DTOs.shopsName;
import com.shopify.Models.Buyer;
import com.shopify.Service.BuyerService;

@RestController
@RequestMapping("/api/v2")
public class BuyerController {
	@Autowired
	private BuyerService buyerService;
	//register buyer
	@PostMapping("/register-buyer")
	public Buyer registerBuyer(@RequestBody Buyer buyer) throws Exception {
		String emailId = buyer.getEmailId();
		if(emailId != null && !" ".equals(emailId)) {
			Buyer obj = buyerService.fetchByEmailId(emailId);
			if(obj != null) {
				throw new Exception("User with email id already exists");
			}
			else {
				String pass = buyer.getPass();
				String conPass = buyer.getConPass();
				if(!pass.equals(conPass)) {
					throw new Exception("password and confirm password should be same");
				}
			}
		}
		return buyerService.registerBuyer(buyer);
	}
	//login buyer
	@PostMapping("/login-buyer")
	public Buyer loginBuyer(@RequestBody Buyer buyer) throws Exception {
		String emailId = buyer.getEmailId();
		String pass = buyer.getPass();
		if(emailId != null && !" ".equals(emailId)) {
			Buyer obj = buyerService.fetchByEmailId(emailId);
			if(obj == null) {
				throw new Exception("User doesn't exist");
			}
			else {
				String p = obj.getPass();
				if(!p.equals(pass)) {
					throw new Exception("Password is incorrect");
				}
			}
		}
		return buyerService.fetchByEmailId(emailId);
	}
	//search shops by pin
	@GetMapping("/get-vendors/{pin}")
	public List<shopsName> getByPin(@PathVariable int pin){
		return buyerService.fetchShopsByCity(pin);
	}
	

}
