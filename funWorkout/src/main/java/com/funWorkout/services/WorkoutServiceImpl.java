package com.funWorkout.services;

import com.funWorkout.models.ExerciseWorkoutJoin;
import com.funWorkout.models.User;
import com.funWorkout.models.WorkoutPlan;
import com.funWorkout.repositories.ExerciseWorkoutJoinRepo;
import com.funWorkout.repositories.WorkoutPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    WorkoutPlanRepo workoutPlanRepo;

    @Autowired
    ExerciseWorkoutJoinRepo exerciseWorkoutJoinRepo;


    @Override
    public List<WorkoutPlan> getAllWorkouts() {
        List<WorkoutPlan> returnedList = (List<WorkoutPlan>) workoutPlanRepo.findAll();

        if(returnedList != null){
            for (WorkoutPlan workout : returnedList){
                User user = new User();
                user.setUserId(workout.getUser().getUserId());
                workout.setUser(user);
            }
            return returnedList;
        }
        else{
            return null;
        }
    }

    @Override
    public WorkoutPlan getWorkout(int workoutId) {
        if(workoutPlanRepo.findById(workoutId).isPresent()){
            WorkoutPlan w = workoutPlanRepo.findById(workoutId).get();
            User u = new User();
            u.setUserId(w.getUser().getUserId());
            w.setUser(u);
            return w;
        }
        else{
            return null;
        }
    }

    @Override
    public WorkoutPlan getWorkoutById(int userId) {
        return null;
    }

    @Override
    public List<WorkoutPlan> getWorkout(String Workoutname, int userId) {
        return null;
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
