package com.funWorkout.aspects;

import com.funWorkout.util.MyLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //Logging the return of workout service
    @AfterReturning(pointcut = "execution(* com.funWorkout.services.WorkoutServiceImpl.*(..))", returning = "result")
    public void logAfterWorkoutService(JoinPoint joinPoint, Object result){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Return for method: " + joinPoint.getSignature().getName();
        if(result != null){
            MyLogger.logger.info(logString + " Success");
        }
        else{
            MyLogger.logger.warn(logString + "Returned Null");
        }
    }

    //Logging the errors of the workout service
    @AfterThrowing(pointcut = "execution(* com.funWorkout.services.WorkoutServiceImpl.*(..))", throwing = "error")
    public void logErrorWorkoutService(JoinPoint joinPoint, Throwable error){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Method: " + joinPoint.getSignature().getName() + "Error :" +error.getMessage();
        MyLogger.logger.error(logString);
    }

    //Logging the return of user service
    @AfterReturning(pointcut = "execution(* com.funWorkout.services.UserServiceImpl.*(..))", returning = "result")
    public void logAfterUserService(JoinPoint joinPoint, Object result){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Return for method: " + joinPoint.getSignature().getName();
        if(result != null){
            MyLogger.logger.info(logString + " Success");
        }
        else{
            MyLogger.logger.warn(logString + "Returned Null");
        }
    }

    //Logging the errors of the user service
    @AfterThrowing(pointcut = "execution(* com.funWorkout.services.UserServiceImpl.*(..))", throwing = "error")
    public void logErrorUserService(JoinPoint joinPoint, Throwable error){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Method: " + joinPoint.getSignature().getName() + "Error :" +error.getMessage();
        MyLogger.logger.error(logString);
    }

    //Logging the return of exercise service
    @AfterReturning(pointcut = "execution(* com.funWorkout.services.ExerciseServiceImpl.*(..))", returning = "result")
    public void logAfterExerciseService(JoinPoint joinPoint, Object result){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Return for method: " + joinPoint.getSignature().getName();
        if(result != null){
            MyLogger.logger.info(logString + " Success");
        }
        else{
            MyLogger.logger.warn(logString + "Returned Null");
        }
    }

    //Logging the errors of the exercise service
    @AfterThrowing(pointcut = "execution(* com.funWorkout.services.ExerciseServiceImpl.*(..))", throwing = "error")
    public void logErrorExerciseService(JoinPoint joinPoint, Throwable error){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Method: " + joinPoint.getSignature().getName() + "Error :" +error.getMessage();
        MyLogger.logger.error(logString);
    }

    //Logging the return of Exercise controller
    @AfterReturning(pointcut = "execution(* com.funWorkout.controllers.ExerciseController.*(..))", returning = "result")
    public void logAfterExerciseController(JoinPoint joinPoint, Object result){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Return for method: " + joinPoint.getSignature().getName();
        if(result != null){
            MyLogger.logger.info(logString + " Success");
        }
        else{
            MyLogger.logger.warn(logString + "Returned Null");
        }
    }

    //Logging the errors of the Exercise controller
    @AfterThrowing(pointcut = "execution(* com.funWorkout.controllers.ExerciseController.*(..))", throwing = "error")
    public void logErrorExerciseController(JoinPoint joinPoint, Throwable error){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Method: " + joinPoint.getSignature().getName() + "Error :" +error.getMessage();
        MyLogger.logger.error(logString);
    }

    //Logging the return of User controller
    @AfterReturning(pointcut = "execution(* com.funWorkout.controllers.UserController.*(..))", returning = "result")
    public void logAfterUserController(JoinPoint joinPoint, Object result){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Return for method: " + joinPoint.getSignature().getName();
        if(result != null){
            MyLogger.logger.info(logString + " Success");
        }
        else{
            MyLogger.logger.warn(logString + "Returned Null");
        }
    }

    //Logging the errors of the User controller
    @AfterThrowing(pointcut = "execution(* com.funWorkout.controllers.UserController.*(..))", throwing = "error")
    public void logErrorUserController(JoinPoint joinPoint, Throwable error){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Method: " + joinPoint.getSignature().getName() + "Error :" +error.getMessage();
        MyLogger.logger.error(logString);
    }

    //Logging the return of Workout controller
    @AfterReturning(pointcut = "execution(* com.funWorkout.controllers.WorkoutController.*(..))", returning = "result")
    public void logAfterWorkoutController(JoinPoint joinPoint, Object result){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Return for method: " + joinPoint.getSignature().getName();
        if(result != null){
            MyLogger.logger.info(logString + " Success");
        }
        else{
            MyLogger.logger.warn(logString + "Returned Null");
        }
    }

    //Logging the errors of the Workout controller
    @AfterThrowing(pointcut = "execution(* com.funWorkout.controllers.WorkoutController.*(..))", throwing = "error")
    public void logErrorWorkoutController(JoinPoint joinPoint, Throwable error){
        String logString = "The class: " + joinPoint.getTarget().getClass().getName() + "Method: " + joinPoint.getSignature().getName() + "Error :" +error.getMessage();
        MyLogger.logger.error(logString);
    }

}
