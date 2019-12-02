package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.repository.ProductRepository;

/**
 * This class is used to implement the productService method.It has two methods.
 * 
 * @author Anisha
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	/**
	 * This save method is use to save the fields in the product table. The values
	 * we will set for productDto and we save in product table
	 */

	@Override
	public String saveProductDetails(ProductDto productDto) {
		Product product = new Product();
		if (productDto == null) {
			return "Not Saved";
		}
		product.setPrice(productDto.getPrice());
		product.getProductId();
		product.setProductName(productDto.getProductName());
		productRepository.save(product);
		return "Saved";
	}

	/**
	 * In this search method we give the parameter as product name.
	 * Hereby using filter method the list of products will return.
	 */

	@Override
	public List<Product> searchProductDetails(String productName) throws ProductNotFoundException {
		List<Product> product = productRepository.findAll();
		List<Product> products = new ArrayList<>();
		for (Product productFetch : product) {
			products.add(productFetch);
		}
		products = products.stream().filter(
				productDetail -> productDetail.getProductName().toLowerCase().startsWith(productName.toLowerCase()))
				.collect(Collectors.toList());
		if (products.isEmpty()) {
			throw new ProductNotFoundException("Product Not Found");
		}
		return products;
	}

}
