package com.funWorkout.repositories;


import com.funWorkout.models.WorkoutPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepo extends CrudRepository<WorkoutPlan, Integer> {
}
