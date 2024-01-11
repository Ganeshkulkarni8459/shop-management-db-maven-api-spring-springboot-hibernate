package home_screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import product_management.ProductManagementScreen;
import user_management.UserManagementScreen;

public class HomeScreenController {

	@FXML
	private Button userManagement;

	@FXML
	private Button productManagement;

	@FXML
	private Button backToHome;


	public void showUserManagementScreen(ActionEvent event) {
		new UserManagementScreen().show();
	}
	public void showProductManagementScreen(ActionEvent event) {
		new ProductManagementScreen().show();

	}
	public void backToHomeScreen(ActionEvent event) {
		new LoginScreen().show();
	}
}
