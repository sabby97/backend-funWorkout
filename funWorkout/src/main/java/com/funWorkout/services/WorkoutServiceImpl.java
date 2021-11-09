package com.funWorkout.services;

import com.funWorkout.models.ExerciseWorkoutJoin;
import com.funWorkout.models.WorkoutPlan;
import com.funWorkout.repositories.ExerciseWorkoutJoinRepo;
import com.funWorkout.repositories.WorkoutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    @Autowired
    WorkoutRepo wr;

    @Autowired
    ExerciseWorkoutJoinRepo ewjr;


    @Override
    public List<WorkoutPlan> getAllWorkouts() {
        List<WorkoutPlan> returnedList = (List<WorkoutPlan>) wr.findAll();
        System.out.println(returnedList);
        return returnedList;
    }

    @Override
    public WorkoutPlan addWorkout(WorkoutPlan workout) {

        WorkoutPlan newWorkout = new WorkoutPlan();
        newWorkout.setWorkoutName(workout.getWorkoutName());
        newWorkout.setUser(workout.getUser());

        //Now save the workout
        newWorkout =  wr.save(newWorkout);

        //Replace with saveall?
        //Save the individual joins
        //Each should have an exercise, the order and workout id can be derived
        int orderNumber = 1;
        for(ExerciseWorkoutJoin singleJoin: workout.getExerciseWorkoutJoinList()) {
            //Create a new join
            ExerciseWorkoutJoin newJoin = new ExerciseWorkoutJoin();
            //Set the properties
            newJoin.setWorkoutId(newWorkout.getWorkoutplanId());
            newJoin.setExercise(singleJoin.getExercise());
            newJoin.setWorkoutOrder(orderNumber);
            orderNumber++;
            //Save it
            ewjr.save(newJoin);
        }

        return newWorkout;
    }

    @Override
    public WorkoutPlan updateWorkout(WorkoutPlan workout) {

        WorkoutPlan updatedWorkout = new WorkoutPlan();

        //Update workout values

        //Delete all joins by workoutPlanId (which is the 'id' argument)
        //Create new ones with correct ordering

        return updatedWorkout;

    }

    @Override
    public void deleteWorkout(int id) {

        //Delete workout

        //Delete all joins by workoutPlanId (which is the 'id' argument)

    }

}
