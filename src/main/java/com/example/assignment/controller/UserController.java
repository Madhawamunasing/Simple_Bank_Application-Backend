package com.example.assignment.controller;

import com.example.assignment.collection.User.User;
import com.example.assignment.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Map> getAllUsers() throws Exception {
        try {
            HashMap<String, Object> response = new HashMap<>();
            List<User> users=userService.getAllUsers();
            response.put("success", "true");
            response.put("message", users);
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            throw new Exception("Login failed");
        }

    }

    @PostMapping("/save")
    public ResponseEntity<Map> create(@RequestBody User user) {
        HashMap<String, Object> response = new HashMap<>();
        try {
            User users= userService.save(user);
            response.put("success", "true");
            response.put("message", users);
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            response.put("success", "false");
            response.put("message", "Email is existing");
            return ResponseEntity.ok().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userService.delete(id);
    }

    @GetMapping("/getUserById")

    public ResponseEntity<Map> getUserById(@RequestParam(name = "user_Id") String id) throws Exception {

        try {
            HashMap<String, Object> response = new HashMap<>();
            User users= userService.getUserById(id).orElse(null);
            response.put("success", "true");
            response.put("message", users);
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            throw new Exception("Failed");
        }
    }

    @PostMapping("/update")
    public User save(@RequestBody User user){
        return userService.update(user);
    }

    @GetMapping("/getByEmail")
    public List<User> getByEmail(@RequestParam(name = "email") String email){
        return userService.getAllByEmail(email);
    }

    @GetMapping("/lastName")
    public ResponseEntity<Map> getAllByLastName(@RequestParam(name = "lastName") String lastName) throws Exception {
        HashMap<String, Object> response = new HashMap<>();
        try {
            List<User> users=userService.getAllByLastName(lastName);
            response.put("success", "true");
            response.put("message", users.get(0));
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            response.put("success", "true");
            response.put("message", null);
            return ResponseEntity.ok().body(response);
        }

    }


}
