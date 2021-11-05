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

    @ManyToOne
    @JoinColumn(name = "workout_fk", referencedColumnName = "workoutplanid")
    private WorkoutPlan workoutPlan;

    @Column(name = " workoutorder")
    private int workoutOrder;

    public ExerciseWorkoutJoin() {
    }

    public ExerciseWorkoutJoin(Exercise exercise, WorkoutPlan workoutPlan, int workoutOrder) {
        this.exercise = exercise;
        this.workoutPlan = workoutPlan;
        this.workoutOrder = workoutOrder;
    }

    public ExerciseWorkoutJoin(int workoutJoinId, Exercise exercise, WorkoutPlan workoutPlan, int workoutOrder) {
        this.workoutJoinId = workoutJoinId;
        this.exercise = exercise;
        this.workoutPlan = workoutPlan;
        this.workoutOrder = workoutOrder;
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

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public int getWorkoutOrder() {
        return workoutOrder;
    }

    public void setWorkoutOrder(int workoutOrder) {
        this.workoutOrder = workoutOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseWorkoutJoin that = (ExerciseWorkoutJoin) o;
        return getWorkoutJoinId() == that.getWorkoutJoinId() && getWorkoutOrder() == that.getWorkoutOrder() && Objects.equals(getExercise(), that.getExercise()) && Objects.equals(getWorkoutPlan(), that.getWorkoutPlan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkoutJoinId(), getExercise(), getWorkoutPlan(), getWorkoutOrder());
    }

    @Override
    public String toString() {
        return "ExerciseWorkoutJoin{" +
                "workoutJoinId=" + workoutJoinId +
                ", exercise=" + exercise +
                ", workoutPlan=" + workoutPlan +
                ", workoutOrder=" + workoutOrder +
                '}';
    }
}
