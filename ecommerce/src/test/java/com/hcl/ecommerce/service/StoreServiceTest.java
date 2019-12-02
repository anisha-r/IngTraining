package com.hcl.ecommerce.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreServiceTest {
	
	@InjectMocks
	StoreServiceImpl storeServiceImpl;
	
	@Mock
	StoreRepository storeRepository;
	
	@Test
	public void saveStoreDetailsPositiveTest()    {
		StoreDto storeDto = new StoreDto();
		storeDto.setStoreName("xyz");
		storeDto.setContactNo(123456L);
		storeDto.setStoreLocation("abc");
		
		Store store = new Store();
		store.setContactNo(storeDto.getContactNo());
		store.getStoreId();
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		
		
	     when(storeRepository.findByStoreLocation("abc")).thenReturn(new Store());
	     String result = storeServiceImpl.saveStoreDetails(storeDto);
	     assertEquals("Saved", result);
	     assertNotNull(storeDto);
	}
	
	@Test
	public void saveStoreDetailsNegativeTest()    {
		StoreDto storeDto = null;
	     String result = storeServiceImpl.saveStoreDetails(storeDto);
	     assertEquals("Not Saved", result);
	     assertNull(storeDto);
	}
	
 
}
