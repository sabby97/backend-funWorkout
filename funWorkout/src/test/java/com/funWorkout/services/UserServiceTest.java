package com.funWorkout.services;

import static org.junit.jupiter.api.Assertions.*;
import com.funWorkout.models.User;
import com.funWorkout.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepo userRepo;

    private User userMaker(){
        return new User(1,"user","pass",true);
    }

    @Test
    void getUserById(){
        User u = userMaker();

        Optional<User> userOptional = Optional.of(u);

        Mockito.when(userRepo.findById(u.getUserId())).thenReturn(userOptional);

        User actual = userService.getUser(u.getUserId());

        assertEquals(actual.getUserId(),u.getUserId());
    }

    @Test
    void getUserUserNameAndPassword(){
        User u = userMaker();

        Mockito.when(userRepo.findByUserNameAndPassword(u.getUserName(),u.getPassword())).thenReturn(u);

        User actual = userService.getUser(u.getUserName(),u.getPassword());
        assertEquals(actual.getUserName(), u.getUserName());
        assertEquals(actual.getPassword(), u.getPassword());
    }

    @Test
    void getAllUsers(){
        List<User> users = new ArrayList<>();
        users.add(userMaker());

        Mockito.when(userRepo.findAll()).thenReturn(users);
        List<User> actual = userService.getAllUsers();
        assertEquals(actual.get(0).getUserId(), users.get(0).getUserId());
    }

    @Test
    void addUser(){
        User u = userMaker();

        Mockito.when(userRepo.save(u)).thenReturn(userMaker());

        User actual = userService.addUser(u);

        assertEquals(actual.getUserId(),u.getUserId());
        assertEquals(actual.getUserName(), u.getUserName());
        assertEquals(actual.getPassword(), u.getPassword());
        assertEquals(actual.isAdmin(),u.isAdmin());
    }

    @Test
    void updateUser(){
        User u = userMaker();

        Mockito.when(userRepo.save(u)).thenReturn(userMaker());

        User actual = userService.updateUser(u);

        assertEquals(actual.getUserId(),u.getUserId());
        assertEquals(actual.getUserName(), u.getUserName());
        assertEquals(actual.getPassword(), u.getPassword());
        assertEquals(actual.isAdmin(),u.isAdmin());
    }

    @Test
    void deleteUser(){
        User u = userMaker();

        Mockito.doNothing().when(userRepo).deleteById(u.getUserId());

        boolean result = userService.deleteUser(u.getUserId());
        assertTrue(result);
    }

}
