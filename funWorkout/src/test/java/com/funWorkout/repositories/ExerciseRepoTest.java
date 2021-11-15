package com.funWorkout.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.funWorkout.models.Exercise;
import com.funWorkout.models.ExerciseTarget;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
@Transactional
public class ExerciseRepoTest {

    @Autowired
    public ExerciseRepo exerciseRepo;

    @Test
    void getAllExercises(){
        List<Exercise> exerciseList = (List<Exercise>) exerciseRepo.findAll();
        assertFalse(exerciseList.isEmpty());
    }

    @Test
    void getExercise(){
        Exercise exercise = exerciseRepo.findById(1).get();
        assertEquals(1, exercise.getExerciseId());
    }

    @Test
    @Rollback
    void addExercise(){
        ExerciseTarget exerciseTarget = new ExerciseTarget(1, "");
        Exercise exercise = new Exercise(50, "Cobra", exerciseTarget, "", 0);
        exercise = exerciseRepo.save(exercise);
        assertEquals("Cobra",exercise.getExerciseName());
    }

    @Test
    void deleteExercise(){
        ExerciseTarget exerciseTarget = new ExerciseTarget(1, "");
        Exercise exercise = new Exercise(50, "Cobra", exerciseTarget, "", 0);
        exercise = exerciseRepo.save(exercise);
        exerciseRepo.deleteById(exercise.getExerciseId());
        assertFalse(exerciseRepo.findById(exercise.getExerciseId()).isPresent());
    }

}
