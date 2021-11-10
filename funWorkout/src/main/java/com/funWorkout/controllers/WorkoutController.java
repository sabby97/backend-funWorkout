package com.funWorkout.controllers;

import com.funWorkout.models.WorkoutPlan;
import com.funWorkout.services.WorkoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WorkoutController {

    @Autowired
    WorkoutServiceImpl workoutService;

    //get all the workouts
    @GetMapping("/workouts")
    public List<WorkoutPlan> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    //get all the Recommended workouts
    @GetMapping("/workouts/rec")
    public List<WorkoutPlan> getAllRecWorkouts() {
        return workoutService.getAllRecWorkouts();
    }

    //get all workouts by workoutId
    @GetMapping("/workouts/{workoutId}")
    public WorkoutPlan getWorkout(@PathVariable("workoutId") String workoutId){
        return workoutService.getWorkout(Integer.parseInt(workoutId));
    }

    //get all workouts by userId
    @GetMapping("/users/{userId}/workouts")
    public List<WorkoutPlan> getWorkoutForUser(@PathVariable("userId") String userId){
        return workoutService.getWorkoutById(Integer.parseInt(userId));
    }

    //get all workout by searching for name if the user owns the workout
    @GetMapping("/users/{userId}/workouts/search")
    public  List<WorkoutPlan> getWorkoutByName(@PathVariable("userId") String userId, @RequestParam String workoutName){
        return workoutService.getWorkout(workoutName, Integer.parseInt(userId));
    }

    //To add a workout
    @PostMapping(value = "/workouts", consumes = "application/json", produces = "application/json")
    public WorkoutPlan addWorkout(@RequestBody WorkoutPlan workout) {
        return workoutService.addWorkout(workout);
    }

    //To update a workout
    @PutMapping(value = "/workouts/{workoutId}", consumes = "application/json", produces = "application/json")
    public  WorkoutPlan updateWorkout(@RequestBody WorkoutPlan workout, @PathVariable("workoutId") String workoutId){
        workout.setWorkoutplanId(Integer.parseInt(workoutId));
        System.out.println("In controller checking workoutPlanId" + workout.getWorkoutplanId() + workout.getWorkoutplanId() );
        return workoutService.updateWorkout(workout);
    }

    //To delete a workout
    @DeleteMapping(value = "/workouts/{workoutId}")
    public void deleteWorkout(@PathVariable("workoutId") String workoutId){
        workoutService.deleteWorkout(Integer.parseInt(workoutId));
    }

    //Need a get one, update, and delete route
}
