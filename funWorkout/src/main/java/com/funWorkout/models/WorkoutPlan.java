package com.funWorkout.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "workoutplans")
public class WorkoutPlan {

    @Id
    @Column(name = "workoutplanid", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workoutplanId;

    @Column(name = "workoutname")
    private String workoutName;

    @ManyToOne
    @JoinColumn(name = "user_fk", referencedColumnName = "userid")
    private User user;


    @OneToMany
    @JoinColumn(name = "workout_id")
    private List<ExerciseWorkoutJoin> exerciseWorkoutJoinList;


    @Column(name = "workoutlikes")
    private int workoutlikes;

    @Column(name = "isrecommended")
    private boolean isRecommended;

    @Transient
    private List<Exercise> exerciseList;


    public WorkoutPlan() {
    }

    public WorkoutPlan(String workoutName, User user, List<ExerciseWorkoutJoin> exerciseWorkoutJoinList, int workoutlikes, boolean isRecommended, List<Exercise> exerciseList) {
        this.workoutName = workoutName;
        this.user = user;
        this.exerciseWorkoutJoinList = exerciseWorkoutJoinList;
        this.workoutlikes = workoutlikes;
        this.isRecommended = isRecommended;
        this.exerciseList = exerciseList;
    }

    public WorkoutPlan(int workoutplanId, String workoutName, User user, List<ExerciseWorkoutJoin> exerciseWorkoutJoinList, int workoutlikes, boolean isRecommended, List<Exercise> exerciseList) {
        this.workoutplanId = workoutplanId;
        this.workoutName = workoutName;
        this.user = user;
        this.exerciseWorkoutJoinList = exerciseWorkoutJoinList;
        this.workoutlikes = workoutlikes;
        this.isRecommended = isRecommended;
        this.exerciseList = exerciseList;
    }

    public int getWorkoutplanId() {
        return workoutplanId;
    }

    public void setWorkoutplanId(int workoutplanId) {
        this.workoutplanId = workoutplanId;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ExerciseWorkoutJoin> getExerciseWorkoutJoinList() {
        return exerciseWorkoutJoinList;
    }

    public void setExerciseWorkoutJoinList(List<ExerciseWorkoutJoin> exerciseWorkoutJoinList) {
        this.exerciseWorkoutJoinList = exerciseWorkoutJoinList;
    }

    public int getWorkoutlikes() {
        return workoutlikes;
    }

    public void setWorkoutlikes(int workoutlikes) {
        this.workoutlikes = workoutlikes;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setRecommended(boolean recommended) {
        isRecommended = recommended;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutPlan that = (WorkoutPlan) o;
        return getWorkoutplanId() == that.getWorkoutplanId() && getWorkoutlikes() == that.getWorkoutlikes() && isRecommended() == that.isRecommended() && Objects.equals(getWorkoutName(), that.getWorkoutName()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getExerciseWorkoutJoinList(), that.getExerciseWorkoutJoinList()) && Objects.equals(getExerciseList(), that.getExerciseList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkoutplanId(), getWorkoutName(), getUser(), getExerciseWorkoutJoinList(), getWorkoutlikes(), isRecommended(), getExerciseList());
    }

    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "workoutplanId=" + workoutplanId +
                ", workoutName='" + workoutName + '\'' +
                ", user=" + user +
                ", exerciseWorkoutJoinList=" + exerciseWorkoutJoinList +
                ", workoutlikes=" + workoutlikes +
                ", isRecommended=" + isRecommended +
                ", exerciseList=" + exerciseList +
                '}';
    }
}
