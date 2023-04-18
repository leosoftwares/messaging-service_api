package com.loe.messagingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
//@Document(collection = "user")
@Table(name = "online_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userOid;
    private String logonId;
    private String name;
    private String emailId;
    private String password;
}
