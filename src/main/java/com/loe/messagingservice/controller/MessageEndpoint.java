package com.loe.messagingservice.controller;

import com.loe.messagingservice.model.Messages;
import com.loe.messagingservice.model.PasswordLog;
import com.loe.messagingservice.model.User;
import com.loe.messagingservice.service.message.MessageRepo;
import com.loe.messagingservice.service.user.PasswordRepo;
import com.loe.messagingservice.service.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageEndpoint {

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordRepo passwordRepo;

    @GetMapping("get-all-user")
    public List<User> getAllUser() {

        return userRepo.findAll();
    }

    @GetMapping("get-all-msg")
    public List<Messages> getAllMsg() {

        return messageRepo.findAll();
    }

    @PostMapping("logon")
    public ResponseEntity logon(@RequestBody User user) {

        User existingUser = userRepo.getUserByLogonId(user.getLogonId());
        if (existingUser == null)
            return ResponseEntity.badRequest().body("User not found");
        if (!user.getPassword().equals(existingUser.getPassword()))
            return ResponseEntity.badRequest().body("Wrong Password");
        return ResponseEntity.ok().build();
    }

    @PostMapping("signup")
    public ResponseEntity signup(@RequestBody User user){

        User existingUser = userRepo.getUserByLogonId(user.getLogonId());
        if (existingUser == null)
            return ResponseEntity.badRequest().body("Logon id already used");
        user = userRepo.save(user);
        PasswordLog passwordLog = new PasswordLog();
        passwordLog.setPassword(user.getPassword());
        passwordLog.setUserOid(user.getUserOid());
        passwordRepo.save(passwordLog);
        return ResponseEntity.ok(user);
    }

    @PostMapping("reset password")
    public ResponseEntity resetPassword(@RequestBody User user){

        User existingUser = userRepo.getUserByLogonId(user.getLogonId());
        if (existingUser == null)
            return ResponseEntity.badRequest().body("Logon id already used");
        PasswordLog password = passwordRepo.getPasswordLogByUserOidAndPassword(user.getUserOid(), user.getPassword());
        if (password != null)
            return ResponseEntity.badRequest().body("Password already used");
        user = userRepo.save(user);
        PasswordLog passwordLog = new PasswordLog();
        passwordLog.setPassword(user.getPassword());
        passwordLog.setUserOid(user.getUserOid());
        passwordRepo.save(passwordLog);
        return ResponseEntity.ok().build();
    }
}