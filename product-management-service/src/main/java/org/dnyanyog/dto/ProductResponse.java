package org.dnyanyog.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductResponse {
	
	private String status;
	private String message;
	private String productId;
	
	@Autowired
	private ProductData productData;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ProductData getProductData() {
		return productData;
	}

	public void setProductData(ProductData productData) {
		this.productData = productData;
	}

}
