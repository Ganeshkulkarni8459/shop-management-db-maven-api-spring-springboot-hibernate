package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	UsersRepository userRepo;

	public LoginResponse validateUser(LoginRequest loginRequest) {
		LoginResponse response = new LoginResponse();

		List<Users> liuser = userRepo.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
//		System.out.println("Username is :"+loginRequest.getUsername());
//		System.out.println("Password is :"+loginRequest.getPassword());

		if (liuser.size() == 1) {
			response.setStatus("Success");
			response.setMessage("Login Successful");
		} else {
			response.setStatus("Failed");
			response.setMessage("Login Failed");
		}
		return response;
	}
}
