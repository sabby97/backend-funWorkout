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

    public Exercise() {
    }

    public Exercise(String exerciseName, ExerciseTarget exerciseTarget, String exerciseDescription ) {
        this.exerciseName = exerciseName;
        this.exerciseTarget = exerciseTarget;
        this.exerciseDescription = exerciseDescription;
    }

    public Exercise(int exerciseId, String exerciseName, ExerciseTarget exerciseTarget, String exerciseDescription) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseTarget = exerciseTarget;
        this.exerciseDescription = exerciseDescription;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return getExerciseId() == exercise.getExerciseId() && Objects.equals(getExerciseName(), exercise.getExerciseName()) && Objects.equals(getExerciseTarget(), exercise.getExerciseTarget()) && Objects.equals(getExerciseDescription(), exercise.getExerciseDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExerciseId(), getExerciseName(), getExerciseTarget(), getExerciseDescription());
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseId=" + exerciseId +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseTarget=" + exerciseTarget +
                ", exerciseDescription='" + exerciseDescription + '\'' +
                '}';
    }
}
