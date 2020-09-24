package com.home.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import com.home.security.Util.JwtUtil;
import com.home.security.service.CustomUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class CustomOncePerRequestFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		System.out.println("KMG == authorizationHeader in filter " + authorizationHeader);
		String jwt = null;
		String username = null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
            try {
            	username = jwtUtil.extractUserName(jwt);            	
            }catch(ExpiredJwtException e) {
            	response.sendError(HttpServletResponse.SC_FORBIDDEN, "Token expired");
//            	throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage());
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
//            UserDetails userDetails =customUserDetailsService.loadUserByUsername(username);
            UserDetails userDetails = jwtUtil.getJwtUserFromToken(jwt);
            if(jwtUtil.validateToken(jwt,userDetails,request)){
                UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );

                upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(upat);
            }else {
            	throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Please verify token or permissions");
            }
        }
        filterChain.doFilter(request,response);
    }
}
