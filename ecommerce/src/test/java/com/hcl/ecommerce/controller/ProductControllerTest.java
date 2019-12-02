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
import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.service.ProductService;

/**
 * This Test class is for testing the product Controller.It has five methods
 * 
 * @author Anisha
 *
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {

	/**
	 * It will inject an mock for the product Controller 
	 */
	@InjectMocks
	ProductController productController;

	@Mock
	ProductService productService;

	ProductDto productDto = null;

	@Test
	public void saveProductDetailsPositiveTest() {
		productDto = new ProductDto();
		productDto.setPrice(250);
		productDto.setProductName("pendrive");

		Product product = new Product();
		product.setPrice(productDto.getPrice());
		product.setProductId(1);
		product.setProductName(productDto.getProductName());

		Mockito.when(productService.saveProductDetails(productDto)).thenReturn("Saved");
		HttpStatus statuscode = productController.saveProductDetails(productDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);
	}

	@Test
	public void saveProductDetailsNegativeTest() {
		Object actual;
		productDto = new ProductDto();
		productDto.setPrice(null);
		productDto.setProductName("pendrive");

		Product product = new Product();
		product.setPrice(productDto.getPrice());
		product.setProductId(1);
		product.setProductName(productDto.getProductName());

		Mockito.when(productService.saveProductDetails(productDto)).thenReturn(null);
		HttpStatus statuscode = productController.saveProductDetails(productDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statuscode);

		actual = productController.saveProductDetails(productDto).getBody();
		assertEquals("Not Saved", actual);
	}

	@Test
	public void saveProductDetailsNullNegativeTest() {
		Object actual;
		productDto = new ProductDto();
		productDto.setPrice(234);
		productDto.setProductName(null);

		Product product = new Product();
		product.setPrice(productDto.getPrice());
		product.setProductId(1);
		product.setProductName(productDto.getProductName());

		Mockito.when(productService.saveProductDetails(productDto)).thenReturn(null);
		HttpStatus statuscode = productController.saveProductDetails(productDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statuscode);

		actual = productController.saveProductDetails(productDto).getBody();
		assertEquals("Not Saved", actual);
	}

	@Test
	public void searchProductDetailsPositiveTest() throws ProductNotFoundException {
		Product product = new Product();
		product.setProductName("honey");
		product.setProductId(1);
		product.setPrice(320);

		List<Product> products = new ArrayList<Product>();
		products.add(product);

		Mockito.when(productService.searchProductDetails("honey")).thenReturn(products);
		HttpStatus status = productController.searchProductDetails("honey").getStatusCode();
		assertEquals(HttpStatus.OK, status);

	}

	public void searchProductDetailsNegativeTest() throws ProductNotFoundException {
		Object actual;
		Product product = new Product();
		product.setProductName("honey");
		product.setProductId(1);
		product.setPrice(320);

		List<Product> products = new ArrayList<Product>();
		products.add(product);

		Mockito.when(productService.searchProductDetails("honeyJam")).thenReturn(products);
		HttpStatus status = productController.searchProductDetails("honeyJam").getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, status);

		actual = productController.saveProductDetails(productDto).getBody();
		assertEquals("Not Saved", actual);
	}
}
