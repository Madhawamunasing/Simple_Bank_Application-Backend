package com.example.assignment.service.UserService;

import com.example.assignment.collection.User.User;
import com.example.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);

    }

    @Override
    public Optional<User> getUserById(String id) {
        System.out.println(userRepository.findById(id));
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) throws Exception {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        String reqEmail = user.getEmail();
        List<User> existingUser = userRepository.findByEmail(reqEmail);
        if (existingUser.size() != 0) {
            throw new Exception("Failed");
        } else {
            return userRepository.save(user);
        }


    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }


}
