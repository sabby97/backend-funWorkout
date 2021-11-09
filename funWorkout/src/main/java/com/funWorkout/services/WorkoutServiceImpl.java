package com.funWorkout.services;

import com.funWorkout.models.*;
import com.funWorkout.repositories.ExerciseWorkoutJoinRepo;
import com.funWorkout.repositories.WorkoutPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                userCleaner(workout);
                listUpdater(workout);
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
            userCleaner(w);
            listUpdater(w);
            return w;
        }
        else{
            return null;
        }
    }

    @Override
    public List<WorkoutPlan> getWorkoutById(int userId) {
        List<WorkoutPlan> returnedList = workoutPlanRepo.findByUserUserId(userId);

        if(returnedList != null){
            for (WorkoutPlan workout : returnedList){
                userCleaner(workout);
                listUpdater(workout);
            }
            return returnedList;
        }
        else{
            return null;
        }

    }

    @Override
    public List<WorkoutPlan> getWorkout(String workoutName, int userId) {
        List<WorkoutPlan> returnedList = workoutPlanRepo.findByWorkoutNameAndUserUserId(workoutName,userId);

        if(returnedList != null){
            for (WorkoutPlan workout : returnedList){
                userCleaner(workout);
                listUpdater(workout);
            }
            return returnedList;
        }
        else{
            return null;
        }
    }

    @Override
    public WorkoutPlan addWorkout(WorkoutPlan workout) {

        WorkoutPlan newWorkout = new WorkoutPlan();
        newWorkout.setWorkoutName(workout.getWorkoutName());
        newWorkout.setUser(workout.getUser());

        //Now save the workout
        newWorkout =  workoutPlanRepo.save(newWorkout);

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
            exerciseWorkoutJoinRepo.save(newJoin);
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

    //function removes the private information from the user object inside the workoutplan object
    private void userCleaner(WorkoutPlan w){
        User user = new User();
        user.setUserId(w.getUser().getUserId());
        w.setUser(user);
    }

    //function sorts and then iterates throught the list of exerciseWorkoutjoin and add the each individual exercise to exerciseList
    //and sets the exerciseWorkoutjoin list to null
    private void listUpdater(WorkoutPlan w){
        System.out.println(w.getExerciseWorkoutJoinList());

        w.getExerciseWorkoutJoinList().sort(new SortByOrder()); //sort the list
        System.out.println(w.getExerciseWorkoutJoinList());

        List<Exercise> exercises = new ArrayList<>();
        for(ExerciseWorkoutJoin myJoin : w.getExerciseWorkoutJoinList()) { //add the exercises to the list
            exercises.add(myJoin.getExercise());
        }
        w.setExerciseWorkoutJoinList(null); //null the joinlist
        w.setExerciseList(exercises); //set the exerciseList
    }

}
