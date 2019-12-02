package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This is StoreReview class contains 4 fields. 
 * @author anisha
 * @since 25-11-2019
 */


@Entity
@Getter
@Setter
@Table(name = "store_review")
public class StoreReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;
	private Integer userId;
	private Integer storeId;
	private Integer rating;

}
