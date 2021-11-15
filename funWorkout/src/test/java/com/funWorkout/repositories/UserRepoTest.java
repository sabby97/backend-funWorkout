package com.funWorkout.repositories;

import com.funWorkout.models.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
@Transactional
public class UserRepoTest {

    @Autowired
    public UserRepo userRepo;

    @Test
    void getAllUsers(){
        List<User> userList =(List<User>) userRepo.findAll();
        assertFalse(userList.isEmpty());
    }

    @Test
    void getUser(){
        User test = userRepo.findById(1).get();
        assertEquals(1, test.getUserId());
    }

    @Test
    @Rollback
    void addUser(){
        User test = new User(0, "abc", "abc", false);

        test = userRepo.save(test);

        assertNotEquals(0,test.getUserId());
    }

    @Test
    void deleteUser(){
        User test = new User(0, "abc", "abc", false);
        test = userRepo.save(test);
        userRepo.deleteById(test.getUserId());
        assertFalse(userRepo.findById(test.getUserId()).isPresent());
    }

    @Test
    @Rollback
    void findByUserName(){
        User test = new User(0, "abc", "abc", false);
        test = userRepo.save(test);
        assertEquals(test, userRepo.findByUserName("abc"));
    }

    @Test
    @Rollback
    void findByPassword(){
        User test = new User(0, "abc", "abc", false);
        test = userRepo.save(test);
        assertEquals(test, userRepo.findByPassword("abc"));
    }

    @Test
    @Rollback
    void findByUserNameAndPassword(){
        User test = new User(0, "abc", "cba", false);
        test = userRepo.save(test);
        assertEquals(test, userRepo.findByUserNameAndPassword("abc","cba"));
    }

}
