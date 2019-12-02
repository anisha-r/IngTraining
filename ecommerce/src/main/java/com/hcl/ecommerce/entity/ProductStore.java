package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This is product store class contains 4 fields
 * @author anisha
 * @since 25-11-2019
 */


@Entity
@Getter
@Setter
@Table(name = "product_store")
public class ProductStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productStoreId;
	private Integer productId;
	private Integer storeId;
	private Integer price;

}
