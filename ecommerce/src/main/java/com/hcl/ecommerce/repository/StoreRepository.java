package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.ecommerce.entity.Store;

/**
 * This StoreRepository Interface extends JpaRepository and it has two methods.
 * 
 * @author Anisha
 *
 */

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

	/**
	 * This method is used to find by Store Id in store table.
	 * 
	 * @param storeId
	 * @return
	 */

	Store findByStoreId(Integer storeId);

	/**
	 * This method is used to find Store Location in the store table.
	 * 
	 * @param storeLocation
	 * @return
	 */

	Store findByStoreLocation(String storeLocation);

}
