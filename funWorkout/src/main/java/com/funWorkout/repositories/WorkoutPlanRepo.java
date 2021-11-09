package com.funWorkout.repositories;


import com.funWorkout.models.WorkoutPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//check for the user

@Repository
public interface WorkoutPlanRepo extends CrudRepository<WorkoutPlan, Integer> {
    List<WorkoutPlan> findByUserUserId(Integer userId);
    List<WorkoutPlan> findByWorkoutNameAndUserUserId(String name, Integer userId);
    List<WorkoutPlan> findByIsRecommendedTrue();
}
