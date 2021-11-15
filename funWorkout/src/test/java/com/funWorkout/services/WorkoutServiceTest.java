package com.funWorkout.services;

import static org.junit.jupiter.api.Assertions.*;

import com.funWorkout.models.*;
import com.funWorkout.repositories.ExerciseWorkoutJoinRepo;
import com.funWorkout.repositories.WorkoutPlanRepo;
import org.hibernate.jdbc.Work;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
public class WorkoutServiceTest {

    @Autowired
    WorkoutService workoutService;

    @MockBean
    WorkoutPlanRepo workoutPlanRepo;

    @MockBean
    ExerciseWorkoutJoinRepo joinRepo;

    private WorkoutPlan workoutMaker(){
        WorkoutPlan retWorkout = new WorkoutPlan();

        //set user
        User u = new User(1,"user","pass",true);

        //create exercises
        ExerciseTarget target = new ExerciseTarget(1,"everything");
        Exercise exercise1 = new Exercise(1, "first", target, "first", 1);
        Exercise exercise2 = new Exercise(2, "second", target, "second", 2);

        //create the exercise workout joins
        ExerciseWorkoutJoin myJoin1 = new ExerciseWorkoutJoin(1, exercise1, 1, 1);
        ExerciseWorkoutJoin myJoin2 = new ExerciseWorkoutJoin(2, exercise2, 2, 1);

        //create a list of joins
        List<ExerciseWorkoutJoin> joins = new ArrayList<>();
        joins.add(myJoin1);
        joins.add(myJoin2);

        retWorkout.setWorkoutplanId(1);
        retWorkout.setWorkoutName("newWorkout");
        retWorkout.setUser(u);
        retWorkout.setExerciseWorkoutJoinList(joins);
        retWorkout.setWorkoutlikes(0);
        retWorkout.setRecommended(true);

        return retWorkout;
    }
    private List<Exercise> exerciseMaker(){
        ExerciseTarget target = new ExerciseTarget(1,"everything");
        Exercise exercise1 = new Exercise(1, "first", target, "first", 1);
        Exercise exercise2 = new Exercise(2, "second", target, "second", 2);

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise1);
        exercises.add(exercise2);
        return exercises;
    }

    @Test
    void getAllWorkouts(){
        List<WorkoutPlan> workouts = new ArrayList<>();
        workouts.add(workoutMaker());

        Mockito.when(workoutPlanRepo.findAll()).thenReturn(workouts);

        List<WorkoutPlan> actual = workoutService.getAllWorkouts();
        assertEquals(actual.get(0).getWorkoutplanId(),workouts.get(0).getWorkoutplanId());
    }

    @Test
    void getAllRecWorkouts(){
        List<WorkoutPlan> workouts = new ArrayList<>();
        workouts.add(workoutMaker());
        System.out.println("Is the exercise recommended : " + workouts.get(0).isRecommended());

        Mockito.when(workoutPlanRepo.findByIsRecommendedTrue()).thenReturn(workouts);

        List<WorkoutPlan> actual = workoutService.getAllRecWorkouts();
        assertTrue(actual.get(0).isRecommended());
    }

    @Test
    void getWorkout(){
        WorkoutPlan workoutPlan = workoutMaker();

        Optional<WorkoutPlan> workoutPlanOptional = Optional.of(workoutPlan);

        Mockito.when(workoutPlanRepo.findById(workoutPlan.getWorkoutplanId())).thenReturn(workoutPlanOptional);

        WorkoutPlan actual = workoutService.getWorkout(workoutPlan.getWorkoutplanId());
        assertEquals(actual.getWorkoutplanId(),workoutPlan.getWorkoutplanId());
    }

    @Test
    void getWorkoutByUserId(){
        List<WorkoutPlan> workouts = new ArrayList<>();
        workouts.add(workoutMaker());

        Mockito.when(workoutPlanRepo.findByUserUserId(workouts.get(0).getUser().getUserId())).thenReturn(workouts);

        List<WorkoutPlan> actual = workoutService.getWorkoutById(workouts.get(0).getUser().getUserId());
        assertEquals(actual.get(0).getUser().getUserId(),workouts.get(0).getUser().getUserId());
    }

    @Test
    void getWorkoutByNameAndUserId(){
        List<WorkoutPlan> workouts = new ArrayList<>();
        workouts.add(workoutMaker());

        Mockito.when(workoutPlanRepo.findByWorkoutNameAndUserUserId(workouts.get(0).getWorkoutName(),workouts.get(0).getUser().getUserId())).thenReturn(workouts);

        List<WorkoutPlan> actual = workoutService.getWorkout(workouts.get(0).getWorkoutName(),workouts.get(0).getUser().getUserId());
        assertEquals(actual.get(0).getWorkoutName(),workouts.get(0).getWorkoutName());
    }

//    @Test
//    void addWorkout(){
//        WorkoutPlan workoutPlan = workoutMaker();
//        WorkoutPlan tester = workoutMaker();
//        List<Exercise> exercises = exerciseMaker();
//        tester.setExerciseList(exercises);
//
//        Mockito.when(workoutPlanRepo.save(tester)).thenReturn(tester);
//        Mockito.when(joinRepo.saveAll(tester.getExerciseWorkoutJoinList())).thenReturn(workoutPlan);
//
//        WorkoutPlan actual = workoutService.addWorkout(tester);
//        assertNotNull(actual.getExerciseWorkoutJoinList());
//    }

//    @Test
//    void deleteWorkout(){
//
//    }

//    @Test
//    void updateWorkout(){}

}
