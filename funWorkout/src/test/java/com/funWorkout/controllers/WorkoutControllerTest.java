package com.funWorkout.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.funWorkout.models.*;
import com.funWorkout.services.WorkoutService;
import com.funWorkout.services.WorkoutServiceImpl;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
public class WorkoutControllerTest {

    @MockBean
    WorkoutServiceImpl service;

    @Autowired
    MockMvc mvc;

    private WorkoutPlan workoutMaker(){
        WorkoutPlan retWorkout = new WorkoutPlan();

        //set user
        User u = new User(1,"user","pass",true);

        //create exercises
        ExerciseTarget target = new ExerciseTarget(1,"everything");
        Exercise exercise1 = new Exercise(1, "first", target, "first", 1);
        Exercise exercise2 = new Exercise(2, "second", target, "second", 2);

        //create the exercise workout joins
        ExerciseWorkoutJoin myJoin1 = new ExerciseWorkoutJoin(1, exercise1, 1, 1);
        ExerciseWorkoutJoin myJoin2 = new ExerciseWorkoutJoin(2, exercise2, 2, 1);

        //create a list of joins
        List<ExerciseWorkoutJoin> joins = new ArrayList<>();
        joins.add(myJoin1);
        joins.add(myJoin2);

        retWorkout.setWorkoutplanId(1);
        retWorkout.setWorkoutName("newWorkout");
        retWorkout.setUser(u);
        retWorkout.setExerciseWorkoutJoinList(joins);
        retWorkout.setWorkoutlikes(0);
        retWorkout.setRecommended(true);

        return retWorkout;
    }

    private List<WorkoutPlan> workoutsMaker(){
        List<WorkoutPlan> workouts = new ArrayList<>();
        workouts.add(workoutMaker());
        return workouts;
    }

    private String javaToJson (Object o){
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

    @Test
    void getAllWorkouts(){
        Mockito.when(service.getAllWorkouts()).thenReturn(workoutsMaker());
        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/workouts"));
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
    void getAllRecWorkouts(){
        Mockito.when(service.getAllRecWorkouts()).thenReturn(workoutsMaker());
        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/workouts"));
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
    void getWorkout(){
        WorkoutPlan w = workoutMaker();
        Mockito.when(service.getWorkout(w.getWorkoutplanId())).thenReturn(workoutMaker());
        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/workouts/1"));
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

    @Test
    void getWorkoutForUser(){
        WorkoutPlan w = workoutMaker();
        Mockito.when(service.getWorkoutById(w.getUser().getUserId())).thenReturn(workoutsMaker());
        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/users/1/workouts"));
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
    void getWorkoutByName(){
        WorkoutPlan w = workoutMaker();
        Mockito.when(service.getWorkout(w.getWorkoutName(),w.getUser().getUserId())).thenReturn(workoutsMaker());
        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/users/1/workouts"));
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
    void addWorkout(){
        WorkoutPlan w = workoutMaker();
        String json = javaToJson(w);

        if (json != null){
            Mockito.when(service.addWorkout(w)).thenReturn(workoutMaker());

            ResultActions ra = null;
            try {
                ra = mvc.perform(MockMvcRequestBuilders.post("/workouts")
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
    void updateWorkout(){
        WorkoutPlan w = workoutMaker();
        String json = javaToJson(w);

        if (json != null){
            Mockito.when(service.updateWorkout(w)).thenReturn(workoutMaker());

            ResultActions ra = null;
            try {
                ra = mvc.perform(MockMvcRequestBuilders.put("/workouts/1")
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
}
