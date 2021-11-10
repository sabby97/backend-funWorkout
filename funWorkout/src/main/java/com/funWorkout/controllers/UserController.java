package com.funWorkout.controllers;

import com.funWorkout.models.User;
import com.funWorkout.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(Integer.parseInt(userId));
    }


    @GetMapping("/users/find")
    public User getUserByNamePass(@RequestParam String userName, @RequestParam String password) {

        User user = userService.getUser(userName, password);

        if(user != null) {
            return user;
        } else {
            return new User();
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping(value = "/users", consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User change) {
        return userService.updateUser(change);
    }

    @DeleteMapping("/users/{userId}")
    public boolean deleteUser( @PathVariable("userId") int userId ) {
        return userService.deleteUser(userId);
    }
}
