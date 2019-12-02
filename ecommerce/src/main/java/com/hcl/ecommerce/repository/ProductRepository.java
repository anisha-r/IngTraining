package com.hcl.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.ecommerce.entity.Product;

/**
 * This is Product Repository method and it contains three methods.
 * 
 * @author Anisha
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	/**
	 * This method is used to find the product Id in the product table.
	 * 
	 * @param productId
	 * @return
	 */

	Product findByProductId(Integer productId);

	/**
	 * This method is to find the product name in the product table.
	 * 
	 * @param productName
	 * @return
	 */

	List<Product> findByProductName(String productName);

}
