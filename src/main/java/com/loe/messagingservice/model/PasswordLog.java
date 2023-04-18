package com.loe.messagingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
//@Document(collection = "password_log")
//@Table(name = "password_log")
@Entity
public class PasswordLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long userOid;
    private String password;
}
