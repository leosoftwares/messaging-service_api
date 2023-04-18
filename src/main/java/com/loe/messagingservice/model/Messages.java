package com.loe.messagingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
//@Table(name = "messages")
@Entity
//@Document(collection = "messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long messageOid;
    private Long fromUserOid;
    private Long toUserOid;
    private String message;
}
