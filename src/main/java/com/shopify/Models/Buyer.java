package com.shopify.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buyers")
public class Buyer {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String emailId;
	private long num;
	private String pass;
	private String conPass;
}
