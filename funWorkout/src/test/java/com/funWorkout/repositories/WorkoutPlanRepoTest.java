package com.funWorkout.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.funWorkout.models.WorkoutPlan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
@Transactional
public class WorkoutPlanRepoTest {

    @Autowired
    public WorkoutPlanRepo workoutPlanRepo;

    @Test
    void getAllWorkouts(){
        List<WorkoutPlan> workoutPlanList = (List<WorkoutPlan>) workoutPlanRepo.findAll();
        assertFalse(workoutPlanList.isEmpty());
    }

    @Test
    void getWorkout(){
        WorkoutPlan workoutPlan = workoutPlanRepo.findById(1).get();
        assertEquals(1,workoutPlan.getWorkoutplanId());
    }

    @Test
    void getByUserId(){
        List<WorkoutPlan> workoutPlanList = (List<WorkoutPlan>) workoutPlanRepo.findByUserUserId(1);
        assertFalse(workoutPlanList.isEmpty());
        assertEquals(1,workoutPlanList.get(0).getUser().getUserId());
    }

    @Test
    void getByWorkoutNameAndUserId(){
        List<WorkoutPlan> workoutPlanList = (List<WorkoutPlan>) workoutPlanRepo.findByWorkoutNameAndUserUserId("Workout 1",1);
        assertFalse(workoutPlanList.isEmpty());
        assertEquals(1,workoutPlanList.get(0).getUser().getUserId());
        assertEquals("Workout 1",workoutPlanList.get(0).getWorkoutName());
    }

    @Test
    void getByIsRec(){
        List<WorkoutPlan> workoutPlanList = (List<WorkoutPlan>) workoutPlanRepo.findByIsRecommendedTrue();
        assertFalse(workoutPlanList.isEmpty());
        assertTrue(workoutPlanList.get(0).isRecommended());
    }

    @Test
    @Rollback
    void addWorkout(){
        WorkoutPlan workoutPlan = workoutPlanRepo.findById(1).get();
        workoutPlan.setWorkoutplanId(0);
        workoutPlan = workoutPlanRepo.save(workoutPlan);
        assertNotEquals(1, workoutPlan.getWorkoutplanId());
    }

//    @Test
//    @Rollback
//    void deleteWorkout() {
//        asse
//        assertDoesNotThrow(workoutPlanRepo.deleteById(1));
//    }
}
