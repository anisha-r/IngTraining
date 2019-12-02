package com.hcl.ecommerce.dto;

/**
 * This is productStoreDto class contains 3 fields
 * @author anisha
 * @since 25-11-2019
 */
public class ProductStoreDto {
	
	private Integer productId;
	private Integer storeId;
	private Integer price;
	private Double storeRating;
	
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Double getStoreRating() {
		return storeRating;
	}
	public void setStoreRating(Double storeRating) {
		this.storeRating = storeRating;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	

}
