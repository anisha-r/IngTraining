package com.hcl.ecommerce.service;

import java.util.List;
import com.hcl.ecommerce.dto.ProductStoreDto;

/**
 * This is ProductStore service. It has two methods.
 * @author Anisha
 *
 */
public interface ProductStoreService {
	/**
	 * This save method is used to save in the productStore table.
	 * @param productStoreDto
	 * @return
	 */
	String saveProductStoreDetails(ProductStoreDto productStoreDto);
	/**
	 * This is store review method were it give the reviews by giving the productId.
	 * @param productId
	 * @return
	 */
	 List<ProductStoreDto> storeReview(Integer productId);

}
