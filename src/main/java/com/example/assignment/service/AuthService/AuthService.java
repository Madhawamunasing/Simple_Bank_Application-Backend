package com.example.assignment.service.AuthService;

import com.example.assignment.collection.User.User;

import java.util.List;

public interface AuthService {
    List<User> getAllByEmail(String email);

}
