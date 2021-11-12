package com.funWorkout.models;

//Not managed by spring - this is used to identify information from the 'generate custom workout' inputs

import java.util.List;

public class CommandJsonWorkoutGenerator {

    private int workoutLength;
    private int minIntensity;
    private int maxIntensity;
    private List<Boolean> selectedExerciseTargetIds;
    private boolean warmUp;
    private boolean coolDown;


    public CommandJsonWorkoutGenerator() {
    }

    public CommandJsonWorkoutGenerator(int workoutLength, int minIntensity, int maxIntensity, List<Boolean> selectedExerciseTargetIds, boolean warmUp, boolean coolDown) {
        this.workoutLength = workoutLength;
        this.minIntensity = minIntensity;
        this.maxIntensity = maxIntensity;
        this.selectedExerciseTargetIds = selectedExerciseTargetIds;
        this.warmUp = warmUp;
        this.coolDown = coolDown;
    }

    public int getMinIntensity() {
        return minIntensity;
    }

    public void setMinIntensity(int minIntensity) {
        this.minIntensity = minIntensity;
    }

    public int getMaxIntensity() {
        return maxIntensity;
    }

    public void setMaxIntensity(int maxIntensity) {
        this.maxIntensity = maxIntensity;
    }

    public List<Boolean> getSelectedExerciseTargetIds() {
        return selectedExerciseTargetIds;
    }

    public void setSelectedExerciseTargetIds(List<Boolean> selectedExerciseTargetIds) {
        this.selectedExerciseTargetIds = selectedExerciseTargetIds;
    }

    public int getWorkoutLength() {
        return workoutLength;
    }

    public void setWorkoutLength(int workoutLength) {
        this.workoutLength = workoutLength;
    }

    public boolean isWarmUp() {
        return warmUp;
    }

    public void setWarmUp(boolean warmUp) {
        this.warmUp = warmUp;
    }

    public boolean isCoolDown() {
        return coolDown;
    }

    public void setCoolDown(boolean coolDown) {
        this.coolDown = coolDown;
    }

    @Override
    public String toString() {
        return "CommandJsonWorkoutGenerator{" +
                "workoutLength=" + workoutLength +
                ", minIntensity=" + minIntensity +
                ", maxIntensity=" + maxIntensity +
                ", selectedExerciseTargetIds=" + selectedExerciseTargetIds +
                ", warmUp=" + warmUp +
                ", coolDown=" + coolDown +
                '}';
    }
}
