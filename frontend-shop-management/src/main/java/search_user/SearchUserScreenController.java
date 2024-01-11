package search_user;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import common.RestUtil;
import dto.UserData;
import dto.UserRequest;
import dto.UserResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;
import user_management.UserManagementScreen;

public class SearchUserScreenController {

	@FXML
	private TextField nameToSearch;

	@FXML
	private TextField userName;

	@FXML
	private TextField email;

	@FXML
	private TextField password;

	@FXML
	private TextField confirmPassword;

	@FXML
	private TextField role;

	@FXML
	private Button search;

	@FXML
	private Button edit;

	@FXML
	private Button delete;

	@FXML
	private Button close;

	public void searchButton(ActionEvent event) throws SQLException, InterruptedException {

		try {

			String searchUrl = "http://localhost:8081/auth/user/search/" + nameToSearch.getText();

			UserResponse userResponse = RestUtil.sendGetRequest(searchUrl, UserResponse.class);

			if (userResponse.getStatus().equals("fail")) {
				System.out.println("!!!!USER NOT FOUND!!!!!");
			} else {
				UserData userData = userResponse.getUserData();
				userName.setText(userData.getUsername());
				email.setText(userData.getEmail());
				password.setText(userData.getPassword());
				confirmPassword.setText(userData.getConfirmPassword());
				role.setText(userData.getRole());
				System.out.println("User Found");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void editButton(ActionEvent event) throws InterruptedException {
		
		UserRequest userRequest = new UserRequest();
		userRequest.setUsername(userName.getText());
		userRequest.setEmail(email.getText());
		userRequest.setPassword(password.getText());
		userRequest.setConfirmPassword(confirmPassword.getText());
		userRequest.setRole(role.getText());

		try {
			System.out.println(nameToSearch.getText());
			String updateUrl = "http://localhost:8081/auth/user/update/" + nameToSearch.getText();

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
	

	public void deleteButton(ActionEvent event) throws InterruptedException {
		try {
			String deleteUrl = "http://localhost:8081/api/user/delete/" + nameToSearch.getText();

			UserResponse status = RestUtil.sendDeleteRequest(deleteUrl, UserResponse.class);

			if (status.getStatus().equals("Success")) {
				System.out.println("USER DELETED SUCCESSFULLY");
			} else {
				System.out.println("!!!!USER NOT FOUND OR DELETION FAILED!!!!");
			}
		} catch (IOException | InterruptedException e) {
			System.out.println("Error: Failed to delete user - " + e.getMessage());
		}
	}

	public void closeButton(ActionEvent event) {
		new UserManagementScreen().show();
	}
}
