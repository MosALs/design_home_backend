package com.home.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.home.DTO.UserRegisterationDto;
import com.home.Service.AppUserService;
import com.home.entities.AppUserEntity;
import com.home.jsonfilter.View;
import com.home.repositories.AppUserRepository;

@RestController
@RequestMapping(value = "/rest/user")
public class AppUserController {

	// localhost:8080/rest/uset/login?userData=bbb&password=123&&userMobile=123456

	@Autowired
	private AppUserService userService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService usersService;
	@Autowired
	private com.home.services.AppUserService appUserEntityService;

	@GetMapping(value = "/login")
	public ResponseEntity<?> login(@RequestParam("userData") String userData,
			@RequestParam("password") String password) {
		System.out.println("login--------------");
		try {
			return usersService.login(userData, password);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getMessage(), e.getStatus());
		}
	}

	@PostMapping(value = "/Register")
	public ResponseEntity<?> add(@RequestBody UserRegisterationDto user) {

		try {
			return usersService.save(user);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getMessage(), e.getStatus());
		}
	}

	@JsonView(View.AuthenticateInfo.class)
	@GetMapping(value = "/userSummary/{id}")
	public Optional<AppUserEntity> getUserSummart(@PathVariable int id) {
		return appUserEntityService.getUserSummary(id);
	}

  

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveAppUser(@RequestBody AppUserEntity appUserEntity){
        if(appUserEntity.getUserRoleId() == 0){
            return new ResponseEntity<>("user role should not be null",HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(appUserRepository.save(appUserEntity),HttpStatus.OK);
        }
    }

	@RequestMapping(value = "/Add", method = RequestMethod.POST)
	public ResponseEntity<?> svae(@RequestBody UserRegisterationDto dto) {
		try {
			return usersService.save(dto);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getMessage(), e.getStatus());
		}
	}

	@RequestMapping(value = "/saveone", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int add(@RequestBody AppUserEntity appUserEntity) {
			usersService.saveone(appUserEntity);
			return 0;
	}
}
