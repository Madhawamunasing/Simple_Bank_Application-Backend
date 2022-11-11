package com.example.assignment.service.UserService;
import com.example.assignment.collection.User.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers() throws Exception;

    void delete(String id);

    Optional<User> getUserById(String id);


    User save(User user) throws Exception;

    User update(User user);

    List<User> getAllByEmail(String email);

    List<User> getAllByLastName(String lastName);


}

