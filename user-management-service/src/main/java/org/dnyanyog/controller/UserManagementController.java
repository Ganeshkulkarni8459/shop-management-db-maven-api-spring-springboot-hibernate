package org.dnyanyog.controller;


import java.util.List;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserManagementController {
	
	@Autowired
	UserManagementService userService;
	
	@PostMapping(path="/auth/user",consumes= {"application/json","application/xml"},produces= {"application/json","application/xml"})
	public UserResponse addUpdateUser(@RequestBody UserRequest userRequest) {	
		return userService.addUpdateUser(userRequest);
	}
	
	@GetMapping(path="/auth/user/search/{nameToSearch}")
	public UserResponse getSingleUser(@PathVariable String nameToSearch) {
		
		return userService.getSingleUser(nameToSearch);
	}
	@DeleteMapping(path="/api/user/delete/{nameToSearch}")
	public UserResponse deleteUser(@PathVariable String nameToSearch) {
		return userService.deleteUser(nameToSearch);
	}
	
	@PutMapping(path="/auth/user/update/{nameToSearch}")
	public UserResponse updateUser(@PathVariable String nameToSearch,@RequestBody UserRequest userRequest) {
		return userService.updateUser(nameToSearch, userRequest);
	}
	
	@GetMapping(path="/auth/user")
	public List<Users> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping(path="/auth/userIds")
	public List<String> getAllUserNames(){
		return userService.getAllUserNames();
	}
}
