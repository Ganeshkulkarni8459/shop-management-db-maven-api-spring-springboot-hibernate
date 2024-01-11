package dto;

public class UserData {

	private String username;
	private String password;
	private String email;
	private String role;
	private String confirmPassword;
	private long userId;
	private String nameToSearch;

	public String getNameToSearch() {
		return nameToSearch;
	}

	public void setNameToSearch(String nameToSearch) {
		this.nameToSearch = nameToSearch;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
