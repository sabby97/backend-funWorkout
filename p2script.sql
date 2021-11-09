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
	exerciseDescription varchar(500)
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
	workout_id int references workoutPlans(workoutPlanID),
	exercise_fk int references exercises(exerciseID),
	workoutOrder int 
);
	

insert into exercisetargetref 
values (1, 'arms'),
		(2, 'chest'),
		(3, 'back'),
		(4, 'legs'),
		(5, 'core'),
		(6, 'glutes'),
		(7, 'cardio');

insert into exercises 
values  (default, 'Jumping jacks', 1, 7, 'Stand with your feet spread shoulder width apart. jump while raising your hands while widening your stance. Jump again and return to your previous position'),
		(default, 'Warrior pose', 1, 4, 'Stand with your feet shoulder width apart. point one foot so it is perpendicular with your other foot. Point your arms outward and turn your head to the right, and bend your front knee and lean forward. Hold for 30 seconds.'),
		(default, 'Sun salutation', 1, 3, 'stand up straight and lift your arms pointing them directly up. bend backwards, pushing out your chest. then put your arms down and lean forward so you are touching your toes. lift your arms together and bend your knees so that you are pointing upward with your glutes pushed out behind you. return to your original position'),
		(default, 'Push-ups', 2, 2, 'Lay on the floor face forward. place your hands shoulder width apart. while keeping your legs and your back straight, push yourself off the ground, then slowly lower yourself back.'),
		(default, 'Sit-ups', 2, 5, 'Sit on the ground with your legs bent and your feet flat on the ground. Cross your arms across your chest and slowly lean back until you back touches the ground, then lift yourself back up.'),
		(default, 'Pull-ups', 2, 1, 'Find a sturdy bar and grip it with your fingers facing yourself. Pull yourself up so that your chin is the same height as the bar, and then lower yourself back down.'),
		(default, 'Lunges', 3, 4, 'Stand with your legs shoulder width apart. take a large step forward, then bend your knees so that you are in a kneeling position, almost touching the ground but not quite. return to standing and repeat with your other leg.'),
		(default, 'Squats', 3, 6, 'Stand with your feet shoulder width apart. bend your knees and crouch slowly while keeping them facing forward. keep your back straight and put your arms forward for balance. return to your original position'),
		(default, 'Bench press', 3, 2, 'Lay back on a workout bench with a barbell. Lift the barbell so your arms are extended, and then slowly bring it down so the barbell is just above your chest. Lift back up and repeat');
		
insert into users 
values	(default, 'gymleader', 'guest', true),
		(default, 'athleticaaron', 'password', false),		
		(default, 'builtbenjamin', 'password', false),
		(default, 'cardiokaren', 'password', false),
		(default, 'deadliftdarren', 'password', false),
		(default, 'exerciseerica', 'password', false),
		(default, 'fitfreddy', 'password', false),
		(default, 'gameongarry', 'password', false);
		
insert into exercises values  (default, 'Warmup placeholder', 4, 1, 'This is an example warmup');
insert into exercises values  (default, 'Warmup placeholder 2', 4, 1, 'This is another example warmup');
insert into exercises values  (default, 'Cooldown placeholder', 5, 1, 'This is an example cooldown');
insert into exercises values  (default, 'Cooldown placeholder 2', 5, 1, 'This is another example cooldown');


insert into workoutPlans values (default, 'Workout 1', 1, 0, false);
insert into exerciseWorkoutJoin values (default, 1, 10, 1);
insert into exerciseWorkoutJoin values (default, 1, 3, 2);
insert into exerciseWorkoutJoin values (default, 1, 5, 3);
insert into exerciseWorkoutJoin values (default, 1, 6, 4);
insert into exerciseWorkoutJoin values (default, 1, 12, 5);

select * from exercisetargetref;
select * from exercises;
select * from workoutplans;
select * from users;
select * from exerciseWorkoutJoin;