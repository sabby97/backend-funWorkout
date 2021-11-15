package com.funWorkout.services;

import static org.junit.jupiter.api.Assertions.*;

import com.funWorkout.models.Exercise;
import com.funWorkout.models.ExerciseTarget;
import com.funWorkout.models.User;
import com.funWorkout.repositories.ExerciseRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
public class ExerciseServiceTest {

    @Autowired
    ExerciseService service;

    @MockBean
    ExerciseRepo repo;

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
    void getExerciseById(){
        Exercise e = exerciseMaker();

        Optional<Exercise> exerciseOptional = Optional.of(e);

        Mockito.when(repo.findById(e.getExerciseId())).thenReturn(exerciseOptional);

        Exercise actual = service.getExerciseById(e.getExerciseId());
        assertEquals(actual.getExerciseId(), e.getExerciseId());
    }

    @Test
    void getAllExercises(){
        Mockito.when(repo.findAll()).thenReturn(exerciseListMaker());

        List<Exercise> actual = service.getAllExercises();
        assertNotNull(actual);
    }

    @Test
    void addExercise(){
        Exercise e = exerciseMaker();

        Mockito.when(repo.save(e)).thenReturn(exerciseMaker());

        Exercise actual = service.addExercise(e);

        assertEquals(actual.getExerciseId(), e.getExerciseId());
        assertEquals(actual.getExerciseName(), e.getExerciseName());
        assertEquals(actual.getExerciseIntensity(), e.getExerciseIntensity());
        assertEquals(actual.getExerciseDescription(), e.getExerciseDescription());

    }

    @Test
    void updateExercise(){
        Exercise e = exerciseMaker();

        Mockito.when(repo.save(e)).thenReturn(exerciseMaker());

        Exercise actual = service.updateExercise(e);

        assertEquals(actual.getExerciseId(), e.getExerciseId());
        assertEquals(actual.getExerciseName(), e.getExerciseName());
        assertEquals(actual.getExerciseIntensity(), e.getExerciseIntensity());
        assertEquals(actual.getExerciseDescription(), e.getExerciseDescription());
    }

//    @Test
//    void deleteExerciseById(){
//        Exercise e = exerciseMaker();
//
//        Mockito.doNothing().when(repo.deleteById(e.getExerciseId()));
//
//        assertDoesNotThrow(service.deleteExerciseById(e.getExerciseId()));
//    }

//    @Test
//    void generateRandomWorkout(){
//        List<Exercise> exercises = exerciseListMaker();
//        Mockito.when(repo.findAll()).thenReturn(exercises);
//        List<Exercise> actual = service.generateRandomWorkout();
//        assertNotNull(actual);
//    }

}
