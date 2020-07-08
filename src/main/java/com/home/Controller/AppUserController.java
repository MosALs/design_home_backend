package com.home.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.home.entities.AppUserEntity;
import com.home.jsonfilter.View;
import com.home.repositories.AppUserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.home.DTO.UserRegisterationDto;
import com.home.Entity.AppUser;
import com.home.Service.AppUserService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/user")
public class AppUserController {


    //localhost:8080/rest/uset/login?userData=bbb&password=123&&userMobile=123456

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService usersService;

    @Autowired
    private com.home.services.AppUserService appUserEntityService;

    @GetMapping(value = "/login")
    public ResponseEntity<?> login(@RequestParam("userData") String userData, @RequestParam("password") String password) {
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
    public Optional<AppUserEntity> getUserSummart(@PathVariable int id){
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

}
