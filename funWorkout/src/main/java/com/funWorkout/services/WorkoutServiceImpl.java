package com.funWorkout.services;

import com.funWorkout.models.*;
import com.funWorkout.repositories.ExerciseWorkoutJoinRepo;
import com.funWorkout.repositories.WorkoutPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if(!returnedList.isEmpty()){
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
    public List<WorkoutPlan> getAllRecWorkouts() {
        List<WorkoutPlan> returnedList = (List<WorkoutPlan>) workoutPlanRepo.findByIsRecommendedTrue();

        if(returnedList != null && !returnedList.isEmpty()){
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

        if(returnedList != null && !returnedList.isEmpty()){
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

        if(returnedList != null && !returnedList.isEmpty()){
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

        //Save the individual joins
        //Each should have an exercise, the order and workout id can be derived
//        int orderNumber = 1;
//        for(Exercise exercise : workout.getExerciseList()) {
//            //Create a new join
//            ExerciseWorkoutJoin newJoin = new ExerciseWorkoutJoin();
//            //Set the properties
//            newJoin.setWorkoutId(newWorkout.getWorkoutplanId());
//            newJoin.setExercise(exercise);
//            newJoin.setWorkoutOrder(orderNumber);
//            orderNumber++;
//            //Save it
//            exerciseWorkoutJoinRepo.save(newJoin);
//        }

        List<ExerciseWorkoutJoin> myJoins = exercisesToJoins(workout.getExerciseList(), newWorkout.getWorkoutplanId());

        exerciseWorkoutJoinRepo.saveAll(myJoins);

        newWorkout.setExerciseWorkoutJoinList(myJoins);

        return newWorkout;
    }

    @Override
    @Transactional
    public WorkoutPlan updateWorkout(WorkoutPlan workout) {
        //System.out.println("From workoutPlan object : " + workout.getWorkoutplanId());

        //Delete all joins by workoutPlanId (which is the 'id' argument)
        exerciseWorkoutJoinRepo.deleteByWorkoutId(workout.getWorkoutplanId());

        //create a list of exerciseWorkoutjoin
        List<ExerciseWorkoutJoin> temp = exercisesToJoins(workout.getExerciseList(), workout.getWorkoutplanId());

        //save all the joins
        exerciseWorkoutJoinRepo.saveAll(temp);

        //set the join to the saved join
        workout.setExerciseWorkoutJoinList(temp);

        //return the workout
        return  workoutPlanRepo.save(workout);
    }

    @Override
    @Transactional
    public void deleteWorkout(int workoutId) {
        //Delete all joins by workoutPlanId (which is the 'id' argument)
        exerciseWorkoutJoinRepo.deleteByWorkoutId(workoutId);

        //Delete workout
        workoutPlanRepo.deleteById(workoutId);
    }

    //function removes the private information from the user object inside the workoutplan object
    private void userCleaner(WorkoutPlan w){
        User user = new User();
        user.setUserId(w.getUser().getUserId());
        user.setAdmin(w.getUser().isAdmin());
        w.setUser(user);
    }

    //function sorts and then iterates throught the list of exerciseWorkoutjoin and add the each individual exercise to exerciseList
    //and sets the exerciseWorkoutjoin list to null
    private void listUpdater(WorkoutPlan w){
        //System.out.println(w.getExerciseWorkoutJoinList());

        w.getExerciseWorkoutJoinList().sort(new SortByOrder()); //sort the list
        //System.out.println(w.getExerciseWorkoutJoinList());

        List<Exercise> exercises = new ArrayList<>();
        for(ExerciseWorkoutJoin myJoin : w.getExerciseWorkoutJoinList()) { //add the exercises to the list
            exercises.add(myJoin.getExercise());
        }
        w.setExerciseWorkoutJoinList(null); //null the joinlist
        w.setExerciseList(exercises); //set the exerciseList
    }

    //return a exerciseWorkoutJoin list from a list of exercises
    List<ExerciseWorkoutJoin> exercisesToJoins(List<Exercise> exercises, int workoutId){
        List<ExerciseWorkoutJoin> joins = new ArrayList<>();
        int orderNumber = 1;
        for(Exercise exercise : exercises) {
            //Create a new join
            ExerciseWorkoutJoin newJoin = new ExerciseWorkoutJoin();
            //Set the properties
            newJoin.setWorkoutId(workoutId);
            newJoin.setExercise(exercise);
            newJoin.setWorkoutOrder(orderNumber);
            joins.add(newJoin);
            orderNumber++;
        }
        return joins;
    }


}
