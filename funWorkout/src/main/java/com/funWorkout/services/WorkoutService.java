package com.funWorkout.services;

import com.funWorkout.models.WorkoutPlan;

import java.util.List;

public interface WorkoutService {

    public List<WorkoutPlan> getAllWorkouts();

    public WorkoutPlan getWorkout(int workoutId);

    public WorkoutPlan getWorkoutById(int userId);

    public List<WorkoutPlan> getWorkout(String Workoutname, int userId);

    public WorkoutPlan addWorkout(WorkoutPlan workout);

    public void deleteWorkout(int workoutId);

    public WorkoutPlan updateWorkout(WorkoutPlan change);
}
