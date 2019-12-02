package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * This is storeDto class contains 3 fields
 * @author anisha
 * @since 25-11-2019
 */
@Getter
@Setter
public class StoreDto {
	
	private String storeName;
	private String storeLocation;
	private Long contactNo;

}
