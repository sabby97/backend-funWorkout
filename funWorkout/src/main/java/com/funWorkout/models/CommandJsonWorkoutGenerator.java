package com.funWorkout.models;

//Not managed by spring - this is used to identify information from the 'generate custom workout' inputs

public class CommandJsonWorkoutGenerator {

    private int intensity;


    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "CommandJsonWorkoutGenerator{" +
                "intensity=" + intensity +
                '}';
    }
}
