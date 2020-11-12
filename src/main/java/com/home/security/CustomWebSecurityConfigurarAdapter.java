package com.home.security;

import com.home.security.filter.CustomOncePerRequestFilter;
import com.home.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


// EnableWebSecurity annotation tells spring container that this class is security configuration class.
@EnableWebSecurity
public class CustomWebSecurityConfigurarAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    CustomOncePerRequestFilter customOncePerRequestFilter;

    // my custom authentication configuration.(login)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("KMG == configure(AuthenticationManagerBuilder auth)");
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoderBean());
    }

    // spring security framework assumes that you have password encoder in your application
    // so you must provide password encoder bean when you are using custom configuration.
    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    // my custom authorization configuration.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("KMG == configure(HttpSecurity http)");
        http.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate","/rest/user/Add").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(customOncePerRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        System.out.println("KMG == configure(WebSecurity web)");
        web.ignoring().antMatchers(HttpMethod.POST,"authenticate");
    }
}
