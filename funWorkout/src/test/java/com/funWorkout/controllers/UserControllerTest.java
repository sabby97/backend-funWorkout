package com.funWorkout.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.funWorkout.models.User;
import com.funWorkout.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
public class UserControllerTest {

    @MockBean
    UserService service;

    @Autowired
    MockMvc mvc;

    String javaToJson (Object o){
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(o);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User userMaker(){
        return new User(1,"user","pass",true);
    }
    private List<User> usersMaker(){
        List<User> users = new ArrayList<>();
        users.add(userMaker());
        return users;
    }

    @Test
    void getUserBYId() throws Exception{
        Mockito.when(service.getUser(1)).thenReturn(userMaker());

        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/users/1"));
        ra.andExpect(status().isOk());

    }

    @Test
    void getUserByNamePass() throws Exception{
        User u = userMaker();
        Mockito.when(service.getUser(u.getUserName(),u.getPassword())).thenReturn(userMaker());

        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/users/find").param("userName",u.getUserName()).param("password",u.getPassword()));
        ra.andExpect(status().isOk());

    }

    @Test
    void getAllUsers() throws Exception{

        Mockito.when(service.getAllUsers()).thenReturn(usersMaker());
        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/users"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assert ra != null;
            ra.andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void addUser() throws Exception{
        User u = userMaker();
        String json = javaToJson(u);
        //System.out.println(test);

        if (json != null){
            Mockito.when(service.addUser(u)).thenReturn(userMaker());

            ResultActions ra = null;
            try {
                ra = mvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (ra != null) {
                    ra.andExpect(status().isOk());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            assertNotNull(json);
        }
    }

    @Test
    void updateUser() throws Exception{
        User u = userMaker();
        String json = javaToJson(u);
        //System.out.println(test);

        if (json != null){
            Mockito.when(service.updateUser(u)).thenReturn(userMaker());

            ResultActions ra = null;
            try {
                ra = mvc.perform(MockMvcRequestBuilders.put("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (ra != null) {
                    ra.andExpect(status().isOk());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            assertNotNull(json);
        }
    }

    @Test
    void deleteUser(){
        Mockito.when(service.deleteUser(1)).thenReturn(true);

        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.delete("/users/1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (ra != null) {
                ra.andExpect(status().isOk());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
