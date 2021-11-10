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

//    @ManyToOne
//    @JoinColumn(name = "workout_id", referencedColumnName = "workoutplandid")
//    @JsonIgnore
//    private WorkoutPlan workoutPlan;

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


//    public ExerciseWorkoutJoin() {
//    }
//
//    public ExerciseWorkoutJoin(Exercise exercise, int workoutOrder, WorkoutPlan workoutPlan) {
//        this.exercise = exercise;
//        this.workoutOrder = workoutOrder;
//        this.workoutPlan = workoutPlan;
//    }
//
//    public ExerciseWorkoutJoin(int workoutJoinId, Exercise exercise, int workoutOrder, WorkoutPlan workoutPlan) {
//        this.workoutJoinId = workoutJoinId;
//        this.exercise = exercise;
//        this.workoutOrder = workoutOrder;
//        this.workoutPlan = workoutPlan;
//    }
//
//    public int getWorkoutJoinId() {
//        return workoutJoinId;
//    }
//
//    public void setWorkoutJoinId(int workoutJoinId) {
//        this.workoutJoinId = workoutJoinId;
//    }
//
//    public Exercise getExercise() {
//        return exercise;
//    }
//
//    public void setExercise(Exercise exercise) {
//        this.exercise = exercise;
//    }
//
//    public int getWorkoutOrder() {
//        return workoutOrder;
//    }
//
//    public void setWorkoutOrder(int workoutOrder) {
//        this.workoutOrder = workoutOrder;
//    }
//
//    public WorkoutPlan getWorkoutPlan() {
//        return workoutPlan;
//    }
//
//    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
//        this.workoutPlan = workoutPlan;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ExerciseWorkoutJoin that = (ExerciseWorkoutJoin) o;
//        return getWorkoutJoinId() == that.getWorkoutJoinId() && getWorkoutOrder() == that.getWorkoutOrder() && Objects.equals(getExercise(), that.getExercise()) && Objects.equals(getWorkoutPlan(), that.getWorkoutPlan());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getWorkoutJoinId(), getExercise(), getWorkoutOrder(), getWorkoutPlan());
//    }
//
//    @Override
//    public String
//    toString() {
//        return "ExerciseWorkoutJoin{" +
//                "workoutJoinId=" + workoutJoinId +
//                ", exercise=" + exercise +
//                ", workoutOrder=" + workoutOrder +
//                ", workoutPlan=" + workoutPlan +
//                '}';
//    }
}
