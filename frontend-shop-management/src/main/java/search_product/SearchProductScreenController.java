package search_product;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.RestUtil;
import dto.ProductData;
import dto.ProductRequest;
import dto.ProductResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;
import search_user.SearchUserScreenController;



public class SearchProductScreenController {
	@FXML 
	private TextField nameToSearch;

	@FXML 
	private TextField productName;

	@FXML 
	private TextField productid;

	@FXML 
	private TextField price;

	@FXML 
	private TextField quantity;

	@FXML 
	private TextField category;
	
	@FXML 
	private TextField addConfirmation;

	@FXML 
	private Button search;

	@FXML 
	private Button edit;

	@FXML 
	private Button delete;

	@FXML 
	private Button close;


	public void showSearch(ActionEvent event) throws SQLException, InterruptedException {
		try {
			String searchUrl = "http://localhost:8082/auth/Product/search/"+nameToSearch.getText();
			
			ProductResponse productResponse = RestUtil.sendGetRequest(searchUrl, ProductResponse.class);
			
			if(productResponse.getStatus().equals("fail")) {
				System.out.println("!!!!Product NOT FOUND!!!!!");
			}else {
				ProductData productData = productResponse.getProductData();
				productName.setText(productData.getProductName());
				productid.setText(productData.getProductId());
				price.setText(productData.getPrice());
				quantity.setText(productData.getQuantity());
				category.setText(productData.getCategory());
				
				System.out.println("User Found");	
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void showEdit(ActionEvent event) throws InterruptedException {
		ProductRequest productRequest = new ProductRequest();
		
		productRequest.setProductName(productName.getText());
		productRequest.setProductId(productid.getText());
		productRequest.setQuantity(quantity.getText());
		productRequest.setPrice(price.getText());
		productRequest.setCategory(category.getText());
		
		try {
			String updateUrl = "http://localhost:8082/auth/Product/update/" +nameToSearch.getText();
			
			ProductResponse productResponse = RestUtil.sendPutRequest(updateUrl, ProductResponse.class, productRequest);
			
			if(productResponse.getStatus().equals("Failed")) {
				System.out.println("Product Update Failed: " + productResponse.getMessage());
			}
			else {
				System.out.println("Product Updated Successfully");
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void showDelete(ActionEvent event) throws InterruptedException {
		try {
			String deleteUrl = "http://localhost:8082/auth/Product/delete/"+nameToSearch.getText();
			
			ProductResponse productResponse = RestUtil.sendDeleteRequest(deleteUrl,ProductResponse.class);
			
			if (productResponse.getStatus().equals("Success")) {
				System.out.println("Product DELETED SUCCESSFULLY");
			} else {
				System.out.println("!!!!Product NOT FOUND OR DELETION FAILED!!!!");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void showClose(ActionEvent event) {
		new ProductManagementScreen().show();

	}
}
