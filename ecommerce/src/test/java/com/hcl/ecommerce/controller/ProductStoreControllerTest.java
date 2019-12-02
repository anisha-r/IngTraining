package com.hcl.ecommerce.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import com.hcl.ecommerce.dto.ProductStoreDto;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.service.ProductStoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductStoreControllerTest {
	
	@InjectMocks
	ProductStoreController productStoreController;
	
	@Mock
	ProductStoreService productStoreService;
	
	ProductStoreDto productStoreDto =null;
	
	@Test
	public void saveProductStoreDetailsPositiveTest() {
		productStoreDto = new ProductStoreDto();
		productStoreDto.setProductId(1);
		productStoreDto.setStoreId(1);
		productStoreDto.setPrice(250);
		productStoreDto.setStoreRating(4.0);
		
		ProductStore productStore = new ProductStore();
		productStore.setPrice(productStore.getPrice());
		productStore.setProductId(productStoreDto.getProductId());
		productStore.setProductStoreId(1);
		productStore.setStoreId(productStoreDto.getStoreId());
		
		Mockito.when(productStoreService.saveProductStoreDetails(productStoreDto)).thenReturn("Saved");
		HttpStatus statuscode = productStoreController.saveProductStoreDetails(productStoreDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);
	}

	@Test
	public void saveProductStoreDetailsNull1NegativeTest() {
		
		Object actual;
		productStoreDto = new ProductStoreDto();
		productStoreDto.setProductId(null);
		productStoreDto.setStoreId(1);
		productStoreDto.setPrice(250);
		productStoreDto.setStoreRating(4.0);
		
		ProductStore productStore = new ProductStore();
		productStore.setPrice(productStore.getPrice());
		productStore.setProductId(productStoreDto.getProductId());
		productStore.setProductStoreId(1);
		productStore.setStoreId(productStoreDto.getStoreId());
		
		Mockito.when(productStoreService.saveProductStoreDetails(productStoreDto)).thenReturn(null);
		HttpStatus statuscode = productStoreController.saveProductStoreDetails(productStoreDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statuscode);
		
		actual=productStoreController.saveProductStoreDetails(productStoreDto).getBody();
		assertEquals("Not Saved", actual);
	}
	@Test
	public void saveProductStoreDetailsNull2NegativeTest() {
		
		Object actual;
		productStoreDto = new ProductStoreDto();
		productStoreDto.setProductId(1);
		productStoreDto.setStoreId(null);
		productStoreDto.setPrice(250);
		productStoreDto.setStoreRating(4.0);
		
		ProductStore productStore = new ProductStore();
		productStore.setPrice(productStore.getPrice());
		productStore.setProductId(productStoreDto.getProductId());
		productStore.setProductStoreId(1);
		productStore.setStoreId(productStoreDto.getStoreId());
		
		Mockito.when(productStoreService.saveProductStoreDetails(productStoreDto)).thenReturn(null);
		HttpStatus statuscode = productStoreController.saveProductStoreDetails(productStoreDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statuscode);
		
		actual=productStoreController.saveProductStoreDetails(productStoreDto).getBody();
		assertEquals("Not Saved", actual);
	}
	@Test
	public void saveProductStoreDetailsNull3NegativeTest() {
		
		Object actual;
		productStoreDto = new ProductStoreDto();
		productStoreDto.setProductId(1);
		productStoreDto.setStoreId(1);
		productStoreDto.setPrice(null);
		productStoreDto.setStoreRating(4.0);
		
		ProductStore productStore = new ProductStore();
		productStore.setPrice(productStore.getPrice());
		productStore.setProductId(productStoreDto.getProductId());
		productStore.setProductStoreId(1);
		productStore.setStoreId(productStoreDto.getStoreId());
		
		Mockito.when(productStoreService.saveProductStoreDetails(productStoreDto)).thenReturn(null);
		HttpStatus statuscode = productStoreController.saveProductStoreDetails(productStoreDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statuscode);
		
		actual=productStoreController.saveProductStoreDetails(productStoreDto).getBody();
		assertEquals("Not Saved", actual);
	}
	@Test
	public void saveProductStoreDetailsNull4NegativeTest() {
		
		Object actual;
		productStoreDto = new ProductStoreDto();
		productStoreDto.setProductId(1);
		productStoreDto.setStoreId(1);
		productStoreDto.setPrice(234);
		productStoreDto.setStoreRating(null);
		
		ProductStore productStore = new ProductStore();
		productStore.setPrice(productStore.getPrice());
		productStore.setProductId(productStoreDto.getProductId());
		productStore.setProductStoreId(1);
		productStore.setStoreId(productStoreDto.getStoreId());
		
		Mockito.when(productStoreService.saveProductStoreDetails(productStoreDto)).thenReturn(null);
		HttpStatus statuscode = productStoreController.saveProductStoreDetails(productStoreDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statuscode);
		
		actual=productStoreController.saveProductStoreDetails(productStoreDto).getBody();
		assertEquals("Not Saved", actual);
	}
	
	
	@Test
	public void reviewStoreDetailsPositiveTest() {
		Integer productId = 1;
		ProductStore ProductStore = new ProductStore();
		ProductStore.setPrice(234);
		ProductStore.setProductId(1);
		ProductStore.setStoreId(1);
		ProductStore.setProductStoreId(1);
		
		ProductStoreDto productStoreDto= new ProductStoreDto();
		productStoreDto.setPrice(1);
		productStoreDto.setProductId(1);
		productStoreDto.setStoreId(ProductStore.getStoreId());
		
		List<ProductStoreDto> list = new ArrayList<>();
		list.add(productStoreDto);
		
		Mockito.when(productStoreService.storeReview(productId)).thenReturn(list);
		HttpStatus statuscode = productStoreController.storeReviewDetails(productId).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);
	}
		
		@Test
		public void reviewStoreDetailsNegativeTest() {
			Object actual;
		
			Integer productId = null;
			ProductStore ProductStore = new ProductStore();
			ProductStore.setPrice(234);
			ProductStore.setProductId(1);
			ProductStore.setStoreId(1);
			ProductStore.setProductStoreId(1);
			
			ProductStoreDto productStoreDto= new ProductStoreDto();
			productStoreDto.setPrice(1);
			productStoreDto.setProductId(productId);
			productStoreDto.setStoreId(ProductStore.getStoreId());
			
			List<ProductStoreDto> list = new ArrayList<>();
			list.add(productStoreDto);
			
			Mockito.when(productStoreService.storeReview(productId)).thenReturn(list);
			HttpStatus statuscode = productStoreController.storeReviewDetails(productId).getStatusCode();
			assertEquals(HttpStatus.NOT_FOUND, statuscode);
		
			actual=productStoreController.storeReviewDetails(productId).getBody();
			assertEquals(null, actual);
		
	}
	

}
