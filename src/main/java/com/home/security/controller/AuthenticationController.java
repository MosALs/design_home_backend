package com.home.security.controller;

import com.home.security.model.AuthenticationResponse;
import com.home.security.model.CustomUserDetails;
import com.home.security.service.CustomUserDetailsService;
import java.util.Objects;

import com.home.security.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.home.security.model.AuthenticationRequest;


@RestController()
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
	CustomUserDetailsService customUserDetailsService;

    @Autowired
	JwtUtil jwtUtil;

    @Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		System.out.println("KMG == AuthenticationController.authenticate().first row");

		ResponseEntity<?> responseEntity = checkAuthentication(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		CustomUserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		if (userDetails == null){
			System.out.println("KMG == AuthenticationController.authenticate() == inside if (userDetails == null)");
			return new ResponseEntity<>("Username : "+  authenticationRequest.getUsername() + " is not found in our records",HttpStatus.NOT_FOUND);
		}
		System.out.println("KMG == userDetails.getPassword() :" +userDetails.getPassword());
		System.out.println(passwordEncoder.matches(authenticationRequest.getPassword(),userDetails.getPassword()));
		if(!passwordEncoder.matches(authenticationRequest.getPassword(),passwordEncoder.encode(userDetails.getPassword()))){
			System.out.println("KMG == AuthenticationController.authenticate() == inside if (matching password)");
			return new ResponseEntity<>("Entered password is not correct",HttpStatus.BAD_REQUEST);
		}
		System.out.println("KMG == AuthenticationController.authenticate() == outside if (userDetails == null)");
		String jwt = jwtUtil.generateToken(userDetails);
	    return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	private ResponseEntity<?> checkAuthentication(String username, String password) {
		System.out.println("KMG == checkAuthentication");
		System.out.println(password);
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			return ResponseEntity.ok(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)));
		} catch (AuthenticationException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		catch (BadCredentialsException e) {
//			return new ResponseEntity("Bad credentials!", HttpStatus.BAD_REQUEST);
//		}
	}

}
