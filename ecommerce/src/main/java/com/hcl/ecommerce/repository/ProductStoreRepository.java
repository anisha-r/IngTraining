package com.hcl.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.ecommerce.entity.ProductStore;

/**
 * ProductStoreRepository has two methods.
 * 
 * @author Anisha
 *
 */
@Repository
public interface ProductStoreRepository extends JpaRepository<ProductStore, Integer> {

	/**
	 * This is used to find the productId in the ProductStore table
	 * 
	 * @param productId
	 * @return
	 */

	List<ProductStore> findByProductId(Integer productId);

	
	

}
