package com.learning.springboot.learning.controller;


import com.learning.springboot.learning.data.entities.jwtModel.JwtRequest;
import com.learning.springboot.learning.data.entities.jwtModel.JwtResponse;
import com.learning.springboot.learning.security.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    UserDetailsService userDetailsService;
    //To get User Information

    @Autowired
    AuthenticationManager manager;
    //To authenticate user


    @Autowired
    JwtHelper  helper;
    //To create jwtToken

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        this.doAuthenticate(request.getEmail(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email,String password){
        UsernamePasswordAuthenticationToken token  = new UsernamePasswordAuthenticationToken(email,password);
        try{
            manager.authenticate(token);
        }catch(BadCredentialsException e){
            throw new BadCredentialsException("Invalid UserName Or password");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    String exceptionHandler(){
        return "Invalid credential";
    }
}
