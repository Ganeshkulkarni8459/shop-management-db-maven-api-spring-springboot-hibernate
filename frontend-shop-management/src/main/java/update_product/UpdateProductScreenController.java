package update_product;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.RestUtil;
import dto.ProductRequest;
import dto.ProductResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;


public class UpdateProductScreenController {
	@FXML
	private TextField productNameToUpdate;
	
	@FXML
	private TextField productName;
	
	@FXML
	private TextField productId;
	
	@FXML
	private TextField price;
	
	@FXML
	private TextField quantity;
	
	@FXML
	private TextField category;
	
	@FXML
	private Button update;
	
	@FXML
	private Button close;
	
	public void showUpdate(ActionEvent event) throws InterruptedException {
		ProductRequest productRequest = new ProductRequest();
		
		productRequest.setProductName(productName.getText());
		productRequest.setProductId(productId.getText());
		productRequest.setQuantity(quantity.getText());
		productRequest.setPrice(price.getText());
		productRequest.setCategory(category.getText());
		
		try {
			String updateUrl = "http://localhost:8082/auth/Product/update/" +productNameToUpdate.getText();
			
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
	
	
	public void showClose(ActionEvent event) {
		new ProductManagementScreen().show();
	}

}
