package com.learn.springbootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtIssuerValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springbootsecurity.securityConfig.CustomUserDetailsService;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.oauth2.sdk.util.JWTClaimsSetUtils;
import org.springframework.security.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Jwts;

@Controller
public class JwtTokenAuthenticationController {

	
	@GetMapping("/generate-token")
    public String generateToken()
    {
    	return "Token Generated";
    }
}



