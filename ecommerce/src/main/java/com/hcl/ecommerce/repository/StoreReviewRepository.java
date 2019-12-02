package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hcl.ecommerce.entity.StoreReview;

/**
 * This Store Review Repository extends from jpaRepository and it has a method.
 * @author Anisha
 *
 */
@Repository
public interface StoreReviewRepository extends JpaRepository<StoreReview, Integer>{
	/**
	 * In this method we write an hqlQuery where it is for finding the average of rating by storeId.
	 * @param storeId
	 * @return
	 */
	@Query("SELECT AVG(s.rating) from StoreReview s where s.storeId = ?1")
    Double findByStoreId(Integer storeId);
	
	 
	
	
    
    
}
