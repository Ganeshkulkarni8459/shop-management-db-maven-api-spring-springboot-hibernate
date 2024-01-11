package update_user;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.RestUtil;
import dto.LoginResponse;
import dto.UserRequest;
import dto.UserResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class UpdateUserScreenController {
	@FXML
	private TextField userNameToUpdate;

	@FXML
	private TextField userName;

	@FXML
	private TextField email;

	@FXML
	private TextField passwordField;

	@FXML
	private TextField confirmPassword;

	@FXML
	private TextField role;

	@FXML
	private Button update;

	@FXML
	private Button close;

	
	public void updateButton(ActionEvent event) throws InterruptedException {
		
		UserRequest userRequest = new UserRequest();
		userRequest.setUsername(userName.getText());
		userRequest.setEmail(email.getText());
		userRequest.setPassword(passwordField.getText());
		userRequest.setConfirmPassword(confirmPassword.getText());
		userRequest.setRole(role.getText());
		
	    try {
//	    	System.out.println(userNameToUpdate.getText());
	        String updateUrl = "http://localhost:8081/auth/user/update/" + userNameToUpdate.getText(); 

	        UserResponse userResponse = RestUtil.sendPutRequest(updateUrl, UserResponse.class, userRequest);

	        if (userResponse.getStatus().equals("Failed")) {
	            System.out.println("User Update Failed: " + userResponse.getMessage());
	        } else {
	            System.out.println("User Updated Successfully");
	        }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

	public void backToUsermanagementScreen(ActionEvent event) {
		new UserManagementScreen().show();
	}

}
