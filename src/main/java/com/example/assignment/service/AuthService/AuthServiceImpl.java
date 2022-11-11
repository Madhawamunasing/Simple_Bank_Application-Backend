package com.example.assignment.service.AuthService;

import com.example.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements UserDetailsService, AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        List<com.example.assignment.collection.User.User> users = getAllByEmail(userName);
        String email = users.get(0).getEmail();
        String password = users.get(0).getPassword();
        return new User(email, password, new ArrayList<>());
    }


    @Override
    public List<com.example.assignment.collection.User.User> getAllByEmail(String email) {

        return userRepository.findByEmail(email);
    }
}
