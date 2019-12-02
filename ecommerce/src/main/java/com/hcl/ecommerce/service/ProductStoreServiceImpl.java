package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.ecommerce.dto.ProductStoreDto;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.StoreReviewRepository;

/**
 * This Implement method implements from the productStore Service method.
 * @author Anisha
 *
 */

@Service
public class ProductStoreServiceImpl implements ProductStoreService{
	
	@Autowired
	ProductStoreRepository productStoreRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	StoreReviewRepository storeReviewRepository;

	/**
	 * In this save method we will pass the productStoreDto values and it will set to the productStore table.
	 * @param productStoreDto
	 * @return
	 */

	@Override
	public String saveProductStoreDetails(ProductStoreDto productStoreDto) {
		if(productStoreDto==null) {
			return "Not Saved";
		}else {
			ProductStore productStore = new ProductStore();
			productStore.setProductId(productStoreDto.getProductId());
			productStore.setStoreId(productStoreDto.getStoreId());
			productStore.getProductStoreId();
			productStoreRepository.save(productStore);
			return "Saved"; 
		}	
		}

	/**
	 * In this method we will pass the productId and we will get the reviews for the particular 
	 * product in different store.
	 * @param productId
	 * @return
	 */

	@Override
	public List<ProductStoreDto> storeReview(Integer productId) {
		List<ProductStore> productStores = productStoreRepository.findByProductId(productId);
		List<ProductStoreDto> listProductStoreDtos=new ArrayList<>();
		for (ProductStore productStore : productStores) {
			ProductStoreDto productStoreDto=new  ProductStoreDto();
			productStoreDto.setPrice(productStore.getPrice());
			productStoreDto.setProductId(productStore.getProductId());
			productStoreDto.setStoreId(productStore.getStoreId());
			productStoreDto.setStoreRating(storeReviewRepository.findByStoreId(productStore.getStoreId()));
			listProductStoreDtos.add(productStoreDto);
		}
		return listProductStoreDtos;

	}

	}
	

