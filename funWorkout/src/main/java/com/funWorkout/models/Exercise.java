package com.funWorkout.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @Column(name = "exerciseid", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciseId;

    @Column(name = "exercisename")
    private String exerciseName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exerciseprimarytarget_fk", referencedColumnName = "exercisetargetid")
    private ExerciseTarget exerciseTarget;

    @Column(name = "exercisedescription")
    private String exerciseDescription;

    /* Intensity 'Codes'
    1 Easy
    2 Medium
    3 Hard
    4 Warmup
    5 Cooldown
     */
    @Column(name= "exerciseintensity")
    private int exerciseIntensity;


    public Exercise() {
    }

    public Exercise(String exerciseName, ExerciseTarget exerciseTarget, String exerciseDescription, int exerciseIntensity) {
        this.exerciseName = exerciseName;
        this.exerciseTarget = exerciseTarget;
        this.exerciseDescription = exerciseDescription;
        this.exerciseIntensity = exerciseIntensity;
    }

    public Exercise(int exerciseId, String exerciseName, ExerciseTarget exerciseTarget, String exerciseDescription, int exerciseIntensity) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseTarget = exerciseTarget;
        this.exerciseDescription = exerciseDescription;
        this.exerciseIntensity = exerciseIntensity;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public ExerciseTarget getExerciseTarget() {
        return exerciseTarget;
    }

    public void setExerciseTarget(ExerciseTarget exerciseTarget) {
        this.exerciseTarget = exerciseTarget;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public int getExerciseIntensity() {
        return exerciseIntensity;
    }

    public void setExerciseIntensity(int exerciseIntensity) {
        this.exerciseIntensity = exerciseIntensity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return exerciseId == exercise.exerciseId && exerciseIntensity == exercise.exerciseIntensity && Objects.equals(exerciseName, exercise.exerciseName) && Objects.equals(exerciseTarget, exercise.exerciseTarget) && Objects.equals(exerciseDescription, exercise.exerciseDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseId, exerciseName, exerciseTarget, exerciseDescription, exerciseIntensity);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseId=" + exerciseId +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseTarget=" + exerciseTarget +
                ", exerciseDescription='" + exerciseDescription + '\'' +
                ", exerciseIntensity=" + exerciseIntensity +
                '}';
    }
}
