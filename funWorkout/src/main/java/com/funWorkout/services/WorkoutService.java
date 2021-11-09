package com.funWorkout.services;

import com.funWorkout.models.WorkoutPlan;

import java.util.List;

public interface WorkoutService {

    public List<WorkoutPlan> getAllWorkouts();

    public WorkoutPlan addWorkout(WorkoutPlan workout);

    public void deleteWorkout(int id);

    public WorkoutPlan updateWorkout(WorkoutPlan workout);
}
