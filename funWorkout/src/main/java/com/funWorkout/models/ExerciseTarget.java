package com.funWorkout.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exercisetargetref")
public class ExerciseTarget {

    @Id
    @Column(name = "exercisetargetid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciseTargetId;

    @Column(name = "exercisetargetname")
    private String exerciseTargetName;

    public ExerciseTarget(String exerciseTargetName) {
        this.exerciseTargetName = exerciseTargetName;
    }

    public ExerciseTarget() {
    }

    public ExerciseTarget(int exerciseTargetId, String exerciseTargetName) {
        this.exerciseTargetId = exerciseTargetId;
        this.exerciseTargetName = exerciseTargetName;
    }

    public int getExerciseTargetId() {
        return exerciseTargetId;
    }

    public void setExerciseTargetId(int exerciseTargetId) {
        this.exerciseTargetId = exerciseTargetId;
    }

    public String getExerciseTargetName() {
        return exerciseTargetName;
    }

    public void setExerciseTargetName(String exerciseTargetName) {
        this.exerciseTargetName = exerciseTargetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseTarget that = (ExerciseTarget) o;
        return getExerciseTargetId() == that.getExerciseTargetId() && Objects.equals(getExerciseTargetName(), that.getExerciseTargetName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExerciseTargetId(), getExerciseTargetName());
    }

    @Override
    public String toString() {
        return "ExerciseTarget{" +
                "exerciseTargetId=" + exerciseTargetId +
                ", exerciseTargetName='" + exerciseTargetName + '\'' +
                '}';
    }
}
