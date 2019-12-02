package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.repository.StoreRepository;

/**
 * This StoreServiceImpl implements from thw StoreService Method.
 * 
 * @author Anisha
 *
 */
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;

	/**
	 * In this method we will pass the storeDto as a parameter and we will set in
	 * the store table.
	 * 
	 * @param
	 * @return
	 */

	@Override
	public String saveStoreDetails(StoreDto storeDto) {
		Store store = new Store();
		if (storeDto != null) {
			store.setContactNo(storeDto.getContactNo());
			store.setStoreLocation(storeDto.getStoreLocation());
			store.setStoreName(storeDto.getStoreName());
			store.getStoreId();
			storeRepository.save(store);
			return "Saved";
		}
		return "Not Saved";
	}
}
