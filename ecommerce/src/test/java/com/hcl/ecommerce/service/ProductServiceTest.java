package com.hcl.ecommerce.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	@Test
	public void saveProductDetailsPositiveTest() {
		ProductDto productDto = new ProductDto();
		productDto.setProductName("Pen");
		productDto.setPrice(250);

		List<Product> list1 = new ArrayList<Product>();
		Product product = new Product();
		product.setPrice(productDto.getPrice());
		product.getProductId();
		product.setProductName(productDto.getProductName());
		list1.add(product);

		when(productRepository.findByProductName("Pen")).thenReturn(list1);
		String result = productServiceImpl.saveProductDetails(productDto);
		assertEquals("Saved", result);
		assertNotNull(productDto);
	}

	@Test
	public void saveProductDetailsNegativeTest() {
		ProductDto productDto = null;
		String result = productServiceImpl.saveProductDetails(productDto);
		assertEquals("Not Saved", result);
		assertNull(productDto);
	}

	@Test
	public void searchProductDetailsPositiveTest() throws ProductNotFoundException {

		List<Product> list1 = new ArrayList<Product>();
		Product product = new Product();
		product.setPrice(250);
		product.setProductId(1);
		product.setProductName("pendrive");
		list1.add(product);
		Mockito.when(productRepository.findAll()).thenReturn(list1);
		List<Product> result = productServiceImpl.searchProductDetails("pendrive");
		assertEquals(list1, result);
	}

	@Test(expected = Exception.class)
	public void searchProductDetailsNegativeTest() throws ProductNotFoundException {
		Product product = new Product();
		product.setPrice(250);
		product.setProductId(1);
		product.setProductName("pendrive");
		List<Product> list1 = new ArrayList<Product>();
		Mockito.when(productRepository.findAll()).thenReturn(list1);
		List<Product> result = productServiceImpl.searchProductDetails("pendrive");
		assertEquals(list1, result);
	}
}
