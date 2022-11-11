package com.example.assignment.controller;

import com.example.assignment.collection.User.User;
import com.example.assignment.model.JwtRequest;
import com.example.assignment.model.JwtResponse;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.service.AuthService.AuthServiceImpl;
import com.example.assignment.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {

        return "Welcome!!";

    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map> authenticate(@RequestBody JwtRequest jwtRequest){
        HashMap<String, Object> response = new HashMap<>();
        if (!verifyCredentials(jwtRequest)){
            response.put("success", "false");
            response.put("message", "Invalid Credentials");
            return ResponseEntity.ok().body(response);
        }else {
            final UserDetails userDetails
                    = authService.loadUserByUsername(jwtRequest.getUsername());

            final String token =
                    jwtUtility.generateToken(userDetails);
            response.put("success", "true");
            response.put("message", token);
            return ResponseEntity.ok().body(response);
        }


    }
    public boolean verifyCredentials(JwtRequest jwtRequest) {
        boolean credentialsMatch = false;
        List<User> existingUser = getUser(jwtRequest);
        if(new BCryptPasswordEncoder().matches(jwtRequest.getPassword(), existingUser.get(0).getPassword())){
            credentialsMatch = true;
        }
        return credentialsMatch;
    }
    public List<User> getUser(JwtRequest jwtRequest) {
        return userRepository.findByEmail(jwtRequest.getUsername());
    }
}
