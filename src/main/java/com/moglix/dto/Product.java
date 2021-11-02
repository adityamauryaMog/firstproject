package com.moglix.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Product {
    
	@Id
	int productId;
	String productName;
	String description;
	
	@ManyToOne
	@JoinColumn(name = "fk_supplier_id")
	Supplier supplier;
	
}
