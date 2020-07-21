package com.home.security.Util;


import com.home.security.model.CustomUserDetails;
import io.jsonwebtoken.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String SECRET_KEY = "kmgsecret";


    public String generateToken(CustomUserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
//        claims.put("username",userDetails.getUsername());
        claims.put("active",userDetails.isActive());
        claims.put("role",userDetails.getRole());

        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }


    public String extractUserName(String token) {
        return extractClaimsFromToken(token, Claims::getSubject);
    }

    private <T> T extractClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaimsFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims;
    }


    public boolean validateToken(String token, UserDetails userDetails, HttpServletRequest httpServletRequest) {
        final String username = extractUserName(token);
        try {
            if (username.equals(userDetails.getUsername()) && !isTokenExpired(token)) {
                return true;
            }
        } catch (SignatureException ex) {
            System.out.println("Invalid JWT Signature");
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
            httpServletRequest.setAttribute("expired", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT exception");
        } catch (IllegalArgumentException ex) {
            System.out.println("Jwt claims string is empty");
        }
        return false;
    }

    public SimpleGrantedAuthority extractRoleFromToken(String token) {
        return (SimpleGrantedAuthority) extractAllClaimsFromToken(token).get("role");
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaimsFromToken(token, Claims::getExpiration);
    }

    public UserDetails getJwtUserFromToken(String token) {
        return new CustomUserDetails(extractUserName(token), null, extractUserStatusFromToken(token), extractRoleFromToken(token));
    }

    private boolean extractUserStatusFromToken(String token) {
        boolean status = (Boolean) extractAllClaimsFromToken(token).get("role");
        return status;
    }
}
