package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.ProductData;
import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.entity.Product;
import org.dnyanyog.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ProductResponse productResponse;
	
	public ProductResponse addProduct(ProductRequest request) {

		Product productTable = new Product();
		productTable.setProductName(request.getProductName());
		productTable.setProductId(request.getProductId());
		productTable.setQuantity(request.getQuantity());
		productTable.setPrice(request.getPrice());
		productTable.setCategory(request.getCategory());

		// long currentBeforeTimeMillis = System.currentTimeMillis();
		
		productTable = productRepo.save(productTable);

		// long currentAfterTimeMillis = System.currentTimeMillis();
		
		productResponse.getProductData().setProductName(productTable.getProductName());
		productResponse.getProductData().setProductId(productTable.getProductId());
		productResponse.getProductData().setQuantity(productTable.getQuantity());
		productResponse.getProductData().setPrice(productTable.getPrice());
		productResponse.getProductData().setCategory(productTable.getCategory());
		productResponse.setMessage("Product Added Successfuly");
		productResponse.setStatus("Success");
		
		return productResponse;
		
	}
	public ProductResponse updateProduct(String nameToSearch , ProductRequest request) {

        List<Product> existingProduct = productRepo.findByProductName(nameToSearch);

        if (existingProduct.isEmpty()) {
        	productResponse.setMessage("Product Not Found");
        	productResponse.setStatus("Failed");
        } else {
            Product product = existingProduct.get(0);

            product.setProductName(request.getProductName());
            product.setProductId(request.getProductId());
            product.setQuantity(request.getQuantity());
            product.setPrice(request.getPrice());
            product.setCategory(request.getCategory());
           
            productRepo.save(product);

            productResponse.setMessage("Product Updated Successfully");
            productResponse.setStatus("Success");
            productResponse.setProductId(product.getProductId());
        }
        return productResponse;
    }

	public ProductResponse getSingleProduct(String nameToSearch) {

		List<Product> receivedData = productRepo.findByProductName(nameToSearch);

		if (receivedData.isEmpty()) {
			productResponse.setStatus("fail");
			productResponse.setMessage("User Not Found");
		} else {
			Product product = receivedData.get(0);
			productResponse.setMessage("Success");
			productResponse.setStatus("Product Found");

			ProductData productData = productResponse.getProductData();

			productData.setProductName(product.getProductName());
			productData.setProductId(product.getProductId());
			productData.setPrice(product.getPrice());
			productData.setQuantity(product.getQuantity());
			productData.setCategory(product.getCategory());
			productData.setProductId(product.getProductId());
		}
		return productResponse;
	}

	public ProductResponse deleteProduct(String nameToSearch) {

		List<Product> existingProduct = productRepo.findByProductName(nameToSearch);

		if (existingProduct.isEmpty()) {
			productResponse.setMessage("Product Not Found");
			productResponse.setStatus("Failed");
		} else {
			Product product = existingProduct.get(0);

			productRepo.delete(product);

			productResponse.setMessage("Product Deleted Successfully");
			productResponse.setStatus("Success");
			productResponse.setProductId(product.getProductId());
		}
		return productResponse;
	}
}
