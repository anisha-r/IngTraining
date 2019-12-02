package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.service.StoreService;


/**
 * The Store Controller contains two methods.
 * @author Anisha
 *
 */
@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	/**
	 * This method will save the store details and update in the store table. 
	 * @param storeDto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<String> saveStoreDetails(@RequestBody StoreDto storeDto){
		if(storeDto.getContactNo()==null||storeDto.getStoreLocation()==null||storeDto.getStoreName()==null) {
		return new ResponseEntity<>("Not Saved", new HttpHeaders(), HttpStatus.NOT_FOUND);
		}else {
			storeService.saveStoreDetails(storeDto);
			return new ResponseEntity<>("Saved", new HttpHeaders(), HttpStatus.OK);
		}
		}
	

}
