package com.home.security.service;

import com.fasterxml.jackson.annotation.JsonView;
import com.home.entities.AppUserEntity;
import com.home.entities.UserRoleEntity;
import com.home.jsonfilter.View;
import com.home.repositories.AppUserRepository;
import com.home.repositories.UserRoleRepository;
import com.home.security.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired()
    private AppUserRepository appUserRepository;

    @Autowired()
    private UserRoleRepository userRoleRepository;


    @JsonView(View.AuthenticateInfo.class)
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("KMG == loadUserByUsername() username before : " + username);
        Optional<AppUserEntity> appUser = appUserRepository.findByUserName(username);

        if (!appUser.isPresent()) {
            // if returned user is null
            return null;
        }
        Optional<UserRoleEntity> userRoleEntity = userRoleRepository.findById(appUser.get().getUserRoleByUserRoleId().getId());
        String userRoleName = userRoleEntity.get().getUserRoleName();
        SimpleGrantedAuthority role = new SimpleGrantedAuthority(userRoleName);
        // app user is not null.
        CustomUserDetails customUserDetails = appUser.map(CustomUserDetails::new).get();
        customUserDetails.setRole(role);
//        appUser.orElseThrow(() -> new UsernameNotFoundException("User name not found !"+ username));
        return customUserDetails;
    }
}
