package com.home.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.home.DTO.UserRegisterationDto;
import com.home.Entity.Users;
import com.home.Service.UsersService;

@RestController
@RequestMapping(value="/rest/user")
public class UserController {
	
	
	//localhost:8080/rest/uset/login?userData=bbb&password=123&&userMobile=123456
	
	@Autowired
    private	UsersService usersService; 

	@GetMapping(value="/login")
	public ResponseEntity<?> login(@RequestParam("userData") String userData,@RequestParam("password")String password) {
		System.out.println("login--------------");
		try {
			return usersService.login( userData, password);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getMessage(),e.getStatus());
		}
	}
	
	@PostMapping(value= "/Register")
	public ResponseEntity<?> add(@RequestBody UserRegisterationDto user) {
		
		try {
			return usersService.save(user);			
		}catch(ResponseStatusException e) {
			return new ResponseEntity<>(e.getMessage(),e.getStatus());
		}
	 
		
	

}
}
