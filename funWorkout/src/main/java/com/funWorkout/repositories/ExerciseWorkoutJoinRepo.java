package com.funWorkout.repositories;

import com.funWorkout.models.ExerciseWorkoutJoin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseWorkoutJoinRepo extends CrudRepository<ExerciseWorkoutJoin, Integer> {

    void deleteByWorkoutId(int workoutId);
}
