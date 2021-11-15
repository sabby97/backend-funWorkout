package com.funWorkout.repositories;

import com.funWorkout.models.ExerciseWorkoutJoin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = com.funWorkout.app.FunWorkoutApplication.class)
@Transactional
public class ExerciseWorkoutJoinRepoTest {
    
    @Autowired
    public ExerciseWorkoutJoinRepo joinRepo;
    
//    @Test
//    void getAllExerciseWorkoutJoins(){
//        List<ExerciseWorkoutJoin> joinList= (List<ExerciseWorkoutJoin> ) joinRepo.findAll();
//        assertFalse(joinList.isEmpty());
//    }

    @Test
    void getExerciseWorkoutJoin(){
        ExerciseWorkoutJoin join = joinRepo.findById(1).get();
        assertEquals(1,join.getWorkoutJoinId());
    }

//    @Test
//    @Rollback
//    void addExerciseWorkoutJoin(){
//        ExerciseWorkoutJoin join = joinRepo.findById(1).get();
//        join.setWorkoutJoinId(500);
//        join = joinRepo.save(join);
//        assertNotEquals(500, join.getWorkoutJoinId());
//    }
//
//    @Test
//    void deleteExerciseWorkoutJoin(){
//        ExerciseWorkoutJoin join = joinRepo.findById(1).get();
//        join.setWorkoutJoinId(500);
//        join = joinRepo.save(join);
//        joinRepo.deleteById(join.getWorkoutJoinId());
//        assertFalse(joinRepo.existsById(join.getWorkoutJoinId()));
//    }

    @Test
    @Rollback
    void deleteByWorkoutId(){
        ExerciseWorkoutJoin join = joinRepo.findById(1).get();
        joinRepo.deleteByWorkoutId(join.getWorkoutId());
        assertFalse(joinRepo.existsById(join.getWorkoutJoinId()));
    }
}
