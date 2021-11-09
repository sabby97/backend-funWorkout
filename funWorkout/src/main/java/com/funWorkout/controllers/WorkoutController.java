package com.funWorkout.controllers;

import com.funWorkout.models.Exercise;
import com.funWorkout.models.WorkoutPlan;
import com.funWorkout.services.WorkoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkoutController {

    @Autowired
    WorkoutServiceImpl ws;

    @GetMapping("/workouts")
    public List<WorkoutPlan> getAllWorkouts() {
        return ws.getAllWorkouts();
    }

    @PostMapping(value = "/workouts", consumes = "application/json", produces = "application/json")
    public WorkoutPlan addWorkout(@RequestBody WorkoutPlan workout) {
        return ws.addWorkout(workout);
    }

    //Need a get one, update, and delete route
}
