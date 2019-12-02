package com.hcl.ecommerce.service;

import java.util.List;
import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;

/**
 * This is Product Service, it has two methods.
 * 
 * @author Anisha
 *
 */

public interface ProductService {

	/**
	 * This method is to save the values in product table.
	 * @param productDto
	 * @return
	 */
	String saveProductDetails(ProductDto productDto);

	/**
	 * This method is to search the product details by using product name
	 * 
	 * @param productName
	 * @return
	 * @throws ProductNotFoundException
	 */
	List<Product> searchProductDetails(String productName) throws ProductNotFoundException;

}
