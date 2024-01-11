package login;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.RestUtil;
import dto.LoginRequest;
import dto.LoginResponse;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginScreenController {

	@FXML
	private TextField email;

	@FXML
	private TextField password;

	@FXML
	private Button loginButton;

	public void login(ActionEvent event) throws SQLException {

		boolean loginStatus = LoginScreenController.ValidateUserAndPassword(email.getText(), password.getText());

		if (loginStatus == true) {
			new HomeScreen().show();
		} else {
			System.out.println("Login Unsuccessful");
		}
	}
	public static boolean ValidateUserAndPassword(String email, String password) throws SQLException {

		LoginRequest loginRequest = new LoginRequest();
		
		loginRequest.setEmail(email);
		loginRequest.setPassword(password);
	
		LoginResponse response;

		try {
			response = RestUtil.sendPostRequest("http://localhost:8081/auth/validate", LoginResponse.class, loginRequest);

			if (response.getStatus().equals("Success")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
