package com.loe.messagingservice.service.user;

import com.loe.messagingservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User getUserByLogonId(String logonId);
}
//public interface UserRepo extends MongoRepository<User, Integer> { }
