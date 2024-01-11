package add_product;

import java.io.IOException;

import common.RestUtil;
import dto.ProductRequest;
import dto.ProductResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;
import user_management.UserManagementScreen;

public class AddProductScreenController {
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
	
	
	public void saveDetails(ActionEvent event) throws InterruptedException {
		ProductRequest addProductRequest = new ProductRequest();
		
		addProductRequest.setProductName(productName.getText());
		addProductRequest.setProductId(productId.getText());
		addProductRequest.setQuantity(quantity.getText());
		addProductRequest.setPrice(price.getText());
		addProductRequest.setCategory(category.getText());
		
		try {
			ProductResponse response = RestUtil.sendPostRequest("http://localhost:8082/auth/product", ProductResponse.class, addProductRequest);
			
		    System.out.println("Product Added Successfully");	
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void backToProductManagementScreen(ActionEvent event) {
		new ProductManagementScreen().show();
	}
}
