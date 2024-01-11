package add_user;

import java.io.IOException;

import common.RestUtil;
import dto.UserRequest;
import dto.UserResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class AddUserScreenController {
	
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
	
	
	public void saveDetails(ActionEvent event) throws IOException, InterruptedException {
//		String query = "INSERT INTO UserData(Username,Email,Password,ConfirmPassword,UserRole)VALUES('"+userName.getText()+"','"+email.getText()+"','"+passwordField.getText()+"','"+confirmPassword.getText()+"','"+role.getText()+"')";
//		
//		DBUtils.executeQuery(query);
	    UserRequest addUserRequest = new UserRequest();
	    
	    addUserRequest.setUsername(userName.getText());
	    addUserRequest.setEmail(email.getText());
	    addUserRequest.setPassword(passwordField.getText());
	    addUserRequest.setConfirmPassword(confirmPassword.getText());
	    addUserRequest.setRole(role.getText());
	    try {
	    	UserResponse response = RestUtil.sendPostRequest("http://localhost:8081/auth/user", UserResponse.class, addUserRequest);
		    
		    System.out.println("User Added Successfuly");	
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void backToUsermanagementScreen(ActionEvent event) {
		new UserManagementScreen().show();
	}
}
