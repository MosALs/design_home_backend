package com.home.security.model;

import com.home.entities.AppUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class CustomUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active ;
    private List<GrantedAuthority> roles;
    private  SimpleGrantedAuthority role;

    public CustomUserDetails(AppUserEntity appUser){
        this.userName = appUser.getUserName();
        this.password = appUser.getPassword();
        this.active = appUser.isActive();
//        this.roles = Arrays.stream(appUser.getUserRoleByUserRoleId())
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        this.role = new SimpleGrantedAuthority(appUser.getUserRoleByUserRoleId().getUserRoleName());
    }


    public CustomUserDetails(String userName, String password, boolean active, SimpleGrantedAuthority role) {
        this.userName = userName;
        this.password = password;
//        this.active = active;
        this.role = role;
    }

    public CustomUserDetails(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
