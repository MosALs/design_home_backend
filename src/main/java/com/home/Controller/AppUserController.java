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
import com.home.Entity.AppUser;
import com.home.Service.AppUserService;

@RestController
@RequestMapping(value="/rest/user")
public class AppUserController {
	
	
	//localhost:8080/rest/uset/login?userData=bbb&password=123&&userMobile=123456
	
	@Autowired
    private	AppUserService usersService; 

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
