package org.dnyanyog.controller;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductManagementController {
	
	@Autowired
	ProductServices productService;
	
	@PostMapping(path="/auth/product",consumes= {"application/json","application/xml"},produces= {"application/json","application/xml"})
	public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {	
		return productService.addProduct(productRequest);
	}
	
	@GetMapping(path="/auth/Product/search/{nameToSearch}")
	public ProductResponse getSingleProduct(@PathVariable String nameToSearch) {
		return productService.getSingleProduct(nameToSearch);
	}
	@DeleteMapping(path="/auth/Product/delete/{nameToSearch}")
	public ProductResponse deleteProduct(@PathVariable String nameToSearch) {
		return productService.deleteProduct(nameToSearch);
	}
	
	@PutMapping(path="/auth/Product/update/{nameToSearch}")
	public ProductResponse updateProduct(@PathVariable String nameToSearch,@RequestBody ProductRequest productRequest) {
		return productService.updateProduct(nameToSearch, productRequest);
	}
}
