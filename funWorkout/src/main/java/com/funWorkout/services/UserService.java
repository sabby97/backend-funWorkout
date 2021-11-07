package com.funWorkout.services;

import com.funWorkout.models.User;

import java.util.List;

public interface UserService {

    public User getUser(int userId);

    public User getUser(String userName, String password);

    public List<User> getAllUsers();
    public User addUser(User user);
    public User updateUser(User change);
    public boolean deleteUser(int userId);

}
