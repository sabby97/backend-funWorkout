package com.funWorkout.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exerciseworkoutjoin")
public class ExerciseWorkoutJoin {

    @Id
    @Column(name = "workout_join_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workoutJoinId;

    @ManyToOne
    @JoinColumn(name = "exercise_fk", referencedColumnName = "exerciseid")
    private Exercise exercise;

    @Column(name = "workoutorder")
    private int workoutOrder;



    @Column(name = "workout_id")
    private int workoutId;



    public ExerciseWorkoutJoin() {
    }

    public ExerciseWorkoutJoin(Exercise exercise, int workoutOrder, int workoutId) {
        this.exercise = exercise;
        this.workoutOrder = workoutOrder;
        this.workoutId = workoutId;
    }

    public ExerciseWorkoutJoin(int workoutJoinId, Exercise exercise, int workoutOrder, int workoutId) {
        this.workoutJoinId = workoutJoinId;
        this.exercise = exercise;
        this.workoutOrder = workoutOrder;
        this.workoutId = workoutId;
    }

    public int getWorkoutJoinId() {
        return workoutJoinId;
    }

    public void setWorkoutJoinId(int workoutJoinId) {
        this.workoutJoinId = workoutJoinId;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getWorkoutOrder() {
        return workoutOrder;
    }

    public void setWorkoutOrder(int workoutOrder) {
        this.workoutOrder = workoutOrder;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseWorkoutJoin that = (ExerciseWorkoutJoin) o;
        return workoutJoinId == that.workoutJoinId && workoutOrder == that.workoutOrder && workoutId == that.workoutId && Objects.equals(exercise, that.exercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutJoinId, exercise, workoutOrder, workoutId);
    }

    @Override
    public String toString() {
        return "ExerciseWorkoutJoin{" +
                "workoutJoinId=" + workoutJoinId +
                ", exercise=" + exercise +
                ", workoutOrder=" + workoutOrder +
                ", workoutId=" + workoutId +
                '}';
    }
}
