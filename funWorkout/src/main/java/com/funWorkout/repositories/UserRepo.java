package com.funWorkout.repositories;

import com.funWorkout.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    User findByUserName(String userName);
    User findByPassword(String password);
    User findByUserNameAndPassword(String userName, String password);


}
