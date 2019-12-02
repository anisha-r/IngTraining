package com.hcl.ecommerce.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.service.StoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreControllerTest {

	@InjectMocks
	StoreController storeController;

	@Mock
	StoreService storeService;

	StoreDto storeDto = null;

	@Test
	public void saveStoretDetailsPositiveTest() {
		StoreDto storeDto=new StoreDto();
		storeDto.setContactNo(123456L);
		storeDto.setStoreLocation("SilkBoard");
		storeDto.setStoreName("ABC");
		
		Store store = new Store();
		store.setContactNo(storeDto.getContactNo());
		store.setStoreId(1);
		store.setStoreName(storeDto.getStoreName());
		
		Mockito.when(storeService.saveStoreDetails(storeDto)).thenReturn("Saved");
		HttpStatus statuscode=storeController.saveStoreDetails(storeDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);
	}
	
	@Test
	public void saveStoreDetailsNegativeTest() {
		Object actual;
		StoreDto storeDto=new StoreDto();
		storeDto.setContactNo(null);
		storeDto.setStoreLocation("SilkBoard");
		storeDto.setStoreName("ABC");
		
		Store store = new Store();
		store.setContactNo(storeDto.getContactNo());
		store.setStoreId(1);
		store.setStoreName(storeDto.getStoreName());
		
		Mockito.when(storeService.saveStoreDetails(storeDto)).thenReturn(null);
		HttpStatus statuscode=storeController.saveStoreDetails(storeDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statuscode);
		
		actual=storeController.saveStoreDetails(storeDto).getBody();
		assertEquals("Not Saved", actual);
	}
	
	

}
