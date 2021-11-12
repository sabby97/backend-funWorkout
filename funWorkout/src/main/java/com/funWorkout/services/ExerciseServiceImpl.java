package com.funWorkout.services;

import com.funWorkout.models.Exercise;
import com.funWorkout.repositories.ExerciseRepo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    ExerciseRepo er;


    @Override
    public Exercise getExerciseById(int id) {
        return er.findById(id).get();
    }

    @Override
    public List<Exercise> getAllExercises() {
        return (List<Exercise>) er.findAll();
    }

    @Override
    public Exercise addExercise(Exercise exercise) {
        return er.save(exercise);
    }

    @Override
    public Exercise updateExercise(Exercise exercise) {
        return er.save(exercise);
    }

    @Override
    public void deleteExerciseById(int id) {
        er.deleteById(id);
    }

    @Override
    public List<Exercise> generateRandomWorkout() {

        //How many exercises to add to the workout
        int workoutLength = 3;

        List<Exercise> allExercises = (List<Exercise>) er.findAll();
        List<Exercise> validExercises = new ArrayList<>();
        List<Exercise> validWarmups = new ArrayList<>();
        List<Exercise> validCooldowns = new ArrayList<>();

        //Only get the exercises of the correct intensity
        for (Exercise exercise: allExercises) {
             if (exercise.getExerciseIntensity() == 4){
                //Get warmups
                validWarmups.add(exercise);
            } else if (exercise.getExerciseIntensity() == 5){
                //Get cooldowns
                validCooldowns.add(exercise);
            } else {
                 validExercises.add(exercise);
             }
        }

        List<Exercise> returnedExercises = new ArrayList<>();

        int listLength = validExercises.size();

        //Add a warmup
        int randomWarmupIndex = (int) Math.floor(Math.random()*validWarmups.size());
        returnedExercises.add(validWarmups.get(randomWarmupIndex));

        //Each loop add a random exercise from the list
        for(int i = 0; i < workoutLength; i++) {
            int randomNum = (int) Math.floor(Math.random()*listLength);
            returnedExercises.add(validExercises.get(randomNum));
        }

        //Add a cooldown
        int randomCooldownIndex = (int) Math.floor(Math.random()*validCooldowns.size());
        returnedExercises.add(validCooldowns.get(randomCooldownIndex));

        return returnedExercises;
    }

    @Override
    public List<Exercise> generateCustomWorkout(int workoutLength, int minIntensity, int maxIntensity, List<Boolean> desiredExerciseTargetIds, boolean warmUp, boolean coolDown) {


        List<Exercise> allExercises = (List<Exercise>) er.findAll();
        List<Exercise> validExercises = new ArrayList<>();
        List<Exercise> validWarmups = new ArrayList<>();
        List<Exercise> validCooldowns = new ArrayList<>();

        for (Exercise exercise: allExercises) {
            //Only get the exercises of the correct intensity and is a valid exercise target
            if(exercise.getExerciseIntensity() >= minIntensity && exercise.getExerciseIntensity() <= maxIntensity
                    && desiredExerciseTargetIds.get(exercise.getExerciseTarget().getExerciseTargetId() - 1)) {

                validExercises.add(exercise);

            } else if (exercise.getExerciseIntensity() == 4){
                //Get warmups
                validWarmups.add(exercise);
            } else if (exercise.getExerciseIntensity() == 5){
                //Get cooldowns
                validCooldowns.add(exercise);
            }
        }

        List<Exercise> returnedExercises = new ArrayList<>();
        int listLength = validExercises.size();

        //Add a warmup
        if(warmUp){
            int randomWarmupIndex = (int) Math.floor(Math.random()*validWarmups.size());
            returnedExercises.add(validWarmups.get(randomWarmupIndex));
        }

        //If no valid exercises exist, don't try to add any
        if(listLength > 0) {
            //Each loop add a random exercise from the list
            for(int i = 0; i < workoutLength; i++) {
                int randomNum = (int) Math.floor(Math.random()*listLength);
                returnedExercises.add(validExercises.get(randomNum));
            }
        }


        //Add a cooldown
        if(coolDown) {
            int randomCooldownIndex = (int) Math.floor(Math.random()*validCooldowns.size());
            returnedExercises.add(validCooldowns.get(randomCooldownIndex));
        }

        return returnedExercises;
    }
}
