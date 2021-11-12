package com.funWorkout.controllers;

import com.funWorkout.models.CommandJsonWorkoutGenerator;
import com.funWorkout.models.Exercise;
import com.funWorkout.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExerciseController {

    @Autowired
    ExerciseService es;

    @GetMapping("/exercises/{exerciseId}")
    public Exercise getExercise(@PathVariable("exerciseId") int exerciseId) {
        return es.getExerciseById(exerciseId);
    }

    @GetMapping("/exercises")
    public List<Exercise> getAllExercises() {
        return es.getAllExercises();
    }

    @PostMapping(value = "/exercises", consumes = "application/json", produces = "application/json")
    public Exercise addExercise(@RequestBody Exercise exercise) {
        return es.addExercise(exercise);
    }

    @PutMapping(value = "/exercises", consumes = "application/json", produces = "application/json")
    public Exercise updateExercise(@RequestBody Exercise exercise) {
        return es.updateExercise(exercise);
    }

    @DeleteMapping(value = "/exercises/{exerciseId}")
    public void deleteExerciseById(@PathVariable("exerciseId") int exerciseId) {
        es.deleteExerciseById(exerciseId);
    }


    //Used for generating workouts from the stored exercises
    @GetMapping("/exercises/randomList")
    public List<Exercise> getRandomWorkout() {
        return es.generateRandomWorkout();
    }

    @PostMapping(value="/exercises/customList", consumes = "application/json", produces = "application/json")
    public List<Exercise> getCustomWorkout(@RequestBody CommandJsonWorkoutGenerator cmdJson) {
        return es.generateCustomWorkout(cmdJson.getWorkoutLength(), cmdJson.getMinIntensity(), cmdJson.getMaxIntensity(), cmdJson.getSelectedExerciseTargetIds(), cmdJson.isWarmUp(), cmdJson.isCoolDown());
    }

}
