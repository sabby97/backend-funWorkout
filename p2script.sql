drop table if exists exerciseWorkoutJoin;
drop table if exists workoutPlans;
drop table if exists exercises;
drop table if exists exerciseTargetRef;
drop table if exists users;


create table users
(
	userID serial primary key,
	username varchar(50),
	password varchar(50),
	isAdmin boolean
	

);

create table exerciseTargetRef
(
	exerciseTargetID serial primary key,
	exerciseTargetName varchar(50)
);

create table exercises
(
	exerciseID serial primary key,
	exerciseName varchar(50),
	exerciseIntensity int,
	exercisePrimaryTarget_fk int references exerciseTargetRef(exerciseTargetID), 
	exerciseDescription varchar(50)
	
 
);


create table workoutPlans
(
	workoutPlanID serial primary key,
	workoutName varchar(50),
	user_fk int references users(userID),
	workoutLikes int,
	isRecommended boolean
);

create table exerciseWorkoutJoin
(	
	workout_join_id serial primary key,
	exercise_fk int references exercises(exerciseID),
	workout_fk int references workoutPlans(workoutPlanID),
	workoutOrder int
);
	
	
