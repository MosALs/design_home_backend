package com.home.security.service;

import com.home.Entity.AppUser;
import com.home.Repository.AppUserRepository;
import com.home.security.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("KMG == username before : "+username);
        Optional<AppUser> appUser = appUserRepository.findByUserName(username);
        System.out.println("KMG == username : "+ appUser.get().getUserName());
        appUser.orElseThrow(() -> new UsernameNotFoundException("User name not found !"+ username));
        return appUser.map(CustomUserDetails::new).get();
    }
}
