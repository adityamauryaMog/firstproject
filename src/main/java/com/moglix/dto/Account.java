package com.moglix.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {
//[msn, gtin, identifierExists, customLabel2, customLabel3, 
//customLabel4, promotionId, isGoogleActive, isFacebookActive, isCriteoActive, availability]
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	
	String msn;
	String gtin;
	String identifierExists;
	String customLabel2;
	String customLabel3;
	String customLabel4;
	String promotionId;
	String isGoogleActive;
	String isFacebookActive;
	String isCriteoActive;
	String availability;
	
	
	
	
}
