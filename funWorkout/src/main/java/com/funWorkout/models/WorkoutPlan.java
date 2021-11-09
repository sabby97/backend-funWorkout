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

    public WorkoutPlan() {
    }

    public WorkoutPlan(String workoutName, User user, List<ExerciseWorkoutJoin> exerciseWorkoutJoinList, int workoutlikes, boolean isRecommended) {
        this.workoutName = workoutName;
        this.user = user;
        this.exerciseWorkoutJoinList = exerciseWorkoutJoinList;
        this.workoutlikes = workoutlikes;
        this.isRecommended = isRecommended;
    }

    public WorkoutPlan(int workoutplanId, String workoutName, User user, List<ExerciseWorkoutJoin> exerciseWorkoutJoinList, int workoutlikes, boolean isRecommended) {
        this.workoutplanId = workoutplanId;
        this.workoutName = workoutName;
        this.user = user;
        this.exerciseWorkoutJoinList = exerciseWorkoutJoinList;
        this.workoutlikes = workoutlikes;
        this.isRecommended = isRecommended;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutPlan that = (WorkoutPlan) o;
        return workoutplanId == that.workoutplanId && workoutlikes == that.workoutlikes && isRecommended == that.isRecommended && Objects.equals(workoutName, that.workoutName) && Objects.equals(user, that.user) && Objects.equals(exerciseWorkoutJoinList, that.exerciseWorkoutJoinList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutplanId, workoutName, user, exerciseWorkoutJoinList, workoutlikes, isRecommended);
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
                '}';
    }
}
