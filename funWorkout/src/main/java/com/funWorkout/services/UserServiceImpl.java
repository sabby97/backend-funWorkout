package com.funWorkout.services;

import com.funWorkout.models.User;
import com.funWorkout.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User getUser(int userId) {

        if (userRepo.findById(userId).isPresent()) {
            return userRepo.findById(userId).get();
        } else {
            return null;
        }
    }

    @Override
    public User getUser(String userName, String password) {

        if ( userRepo.findByUserNameAndPassword(userName, password) != null) {
            return userRepo.findByUserNameAndPassword(userName, password);
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User addUser(User user) {
       User userInDB = userRepo.findByUserNameAndPassword( user.getUserName(), user.getPassword() );
       System.out.println(userInDB);

       // If this user is not in the database then add her
       if( userInDB == null ) {

            if (user != null) {
                return userRepo.save(user);
            } else {
                return null;
            }
        } return null;
    }

    @Override
    public User updateUser(User change) {

        if(change != null) {
            return userRepo.save(change);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteUser(int userId) {

        try {
            userRepo.deleteById(userId);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
