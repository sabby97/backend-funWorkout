package com.funWorkout.repositories;

import com.funWorkout.models.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepo extends CrudRepository<Exercise, Integer> {

}
