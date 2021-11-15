package com.funWorkout.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.funWorkout.models.Exercise;
import com.funWorkout.models.ExerciseTarget;
import com.funWorkout.services.ExerciseService;
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
public class ExerciseControllerTest {

    @MockBean
    ExerciseService service;

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

    private Exercise exerciseMaker(){
        ExerciseTarget target = new ExerciseTarget(1,"everything");
        return new Exercise(1, "first", target, "first", 1);
    }

    private List<Exercise> exerciseListMaker(){
        ExerciseTarget target = new ExerciseTarget(1,"everything");
        Exercise exercise1 = new Exercise(1, "first", target, "first", 1);
        Exercise exercise2 = new Exercise(2, "second", target, "second", 2);

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise1);
        exercises.add(exercise2);
        return exercises;
    }

    @Test
    void getExercise(){
        Mockito.when(service.getExerciseById(1)).thenReturn(exerciseMaker());

        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/exercises/1"));
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
    void getAllExercises(){
        Mockito.when(service.getAllExercises()).thenReturn(exerciseListMaker());

        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/exercises"));
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
    void addExercise(){
        Exercise exercise = exerciseMaker();
        String json = javaToJson(exercise);
        if (json != null){
            Mockito.when(service.addExercise(exercise)).thenReturn(exerciseMaker());

            ResultActions ra = null;
            try {
                ra = mvc.perform(MockMvcRequestBuilders.post("/exercises")
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
    void updateExercise(){
        Exercise exercise = exerciseMaker();
        String json = javaToJson(exercise);
        if (json != null){
            Mockito.when(service.updateExercise(exercise)).thenReturn(exerciseMaker());

            ResultActions ra = null;
            try {
                ra = mvc.perform(MockMvcRequestBuilders.put("/exercises")
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

//    @Test
//    void deleteExercise(){
//        Exercise exercise = exerciseMaker();
//        Mockito.doNothing().when(service.deleteExerciseById(exercise.getExerciseId()));
//
//        ResultActions ra = null;
//        try {
//            ra = mvc.perform(MockMvcRequestBuilders.delete("/exercises/1"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            if (ra != null) {
//                ra.andExpect(status().isOk());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    void getRandomWorkout(){
        Mockito.when(service.generateRandomWorkout()).thenReturn(exerciseListMaker());

        ResultActions ra = null;
        try {
            ra = mvc.perform(MockMvcRequestBuilders.get("/exercises/randomList"));
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
