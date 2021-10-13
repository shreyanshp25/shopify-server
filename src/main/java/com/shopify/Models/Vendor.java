package com.shopify.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vendors")
public class Vendor {
	@Id
	@GeneratedValue
	private long id;
	private String shopName;
	private String emailId;
	private long num;
	private String state;
	private String city;
	private String area;
	private int pin;
	private String pass;
	private String conPass;
	
	@OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "venId", referencedColumnName = "id")
	private List<Products> products;
	
	
}
