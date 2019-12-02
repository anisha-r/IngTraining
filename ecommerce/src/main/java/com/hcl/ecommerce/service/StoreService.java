package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.StoreDto;

/**
 * This StoreService Interface has one method
 * 
 * @author Anisha
 *
 */
public interface StoreService {
	/**
	 * This save method is used to store in the store table.
	 * 
	 * @param storeDto
	 * @return
	 */

	String saveStoreDetails(StoreDto storeDto);

}
