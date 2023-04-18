package com.loe.messagingservice.service.user;

import com.loe.messagingservice.model.PasswordLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepo extends JpaRepository<PasswordLog, Integer> {

    public PasswordLog getPasswordLogByUserOidAndPassword(Long userOid, String password);
}
