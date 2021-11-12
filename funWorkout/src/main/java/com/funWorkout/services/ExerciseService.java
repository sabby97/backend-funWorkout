package com.funWorkout.services;

import com.funWorkout.models.Exercise;

import java.util.List;

public interface ExerciseService {

    public Exercise getExerciseById(int id);

    public List<Exercise> getAllExercises();

    public Exercise addExercise(Exercise exercise);

    public Exercise updateExercise(Exercise exercise);

    public void deleteExerciseById(int id);


    public List<Exercise> generateRandomWorkout();

    public List<Exercise> generateCustomWorkout(int workoutLength, int minIntensity, int maxIntensity, List<Boolean> desiredExerciseTargetIds, boolean warmUp, boolean coolDown);


}
