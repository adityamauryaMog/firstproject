package com.moglix.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Supplier {
	@Id
	String supplierId;
	String SupplierName;
	String supplierPhoneNumber;
	
	

}
