package com.shopify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.DTOs.ProductsDTO;
import com.shopify.Models.Products;
import com.shopify.Models.Vendor;
import com.shopify.Service.VendorService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class VendorController {
	@Autowired
	private VendorService vendorService;
	//sign up
	@PostMapping("/register-vendor")
	public Vendor registerVendor(@RequestBody Vendor vendor) throws Exception {
		String emailId = vendor.getEmailId();
		if(emailId != null && !emailId.equals(" ")) {
			Vendor obj = vendorService.fetchByEmailId(emailId);
			if(obj != null) {
				throw new Exception("Vendor with email Id already exists");
			}
			else {
				String pass = vendor.getPass();
				String conPass = vendor.getConPass();
				if(!pass.equals(conPass)) {
					throw new Exception("Password and confirm password should be same");
				}
				else {
					return vendorService.saveVendor(vendor);
				}
			}
		}
		else {
			throw new Exception("Use a proper email id");
		}
	}
	//login vendor
	@PostMapping("/login-vendor")
	public Vendor signInVendor(@RequestBody Vendor vendor) throws Exception {
		String emailId = vendor.getEmailId();
		String pass = vendor.getPass();
		if(emailId != null &&  !" ".equals(emailId)) {
			Vendor obj = vendorService.fetchByEmailId(emailId);
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
		return vendorService.fetchByEmailId(emailId);
	}
	//add products
	@PutMapping("add-product")
	public Vendor addProduct(@RequestBody Vendor vendor) {
		return vendorService.addProduct(vendor);
	}
	//get vendor by id
	@GetMapping("vendor/{id}")
	public ResponseEntity<Vendor> getVendorById(@PathVariable long id) {
		return vendorService.fetchById(id);
	}
	//get products by id
	@GetMapping("get-products/{id}")
	public List<Products> getProductsOfShop(@PathVariable long id) {
		return vendorService.getPdtsById(id);
	}
	
	
}
