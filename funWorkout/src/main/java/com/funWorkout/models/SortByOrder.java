package com.funWorkout.models;

import java.util.Comparator;

public class SortByOrder implements Comparator<ExerciseWorkoutJoin> {

    @Override
    public int compare(ExerciseWorkoutJoin o1, ExerciseWorkoutJoin o2) {
        return o1.getWorkoutOrder() - o2.getWorkoutOrder();
    }
}