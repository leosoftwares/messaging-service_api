package com.loe.messagingservice.service.message;

import com.loe.messagingservice.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepo extends JpaRepository<Messages, Integer> { }
//public interface MessageRepo extends MongoRepository<Messages, Integer> { }
