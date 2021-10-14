package com.shopify.DTOs;

import java.util.List;

import com.shopify.Models.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerInfoDTO {
	private long id;
	private String shopName;
	private String emailID;
	private long num;
	private String area;
	private List<Products> products;

}
