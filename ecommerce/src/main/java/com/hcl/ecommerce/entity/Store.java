package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This is Store class contains 4 fields. 
 * @author anisha
 * @since 25-11-2019
 */


@Entity
@Getter
@Setter
@Table(name = "store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeId;
	private String storeName;
	private String storeLocation;
	private Long contactNo;

}
