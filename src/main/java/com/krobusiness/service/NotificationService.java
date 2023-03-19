package com.krobusiness.service;

import org.springframework.scheduling.annotation.Async;

import com.krobusiness.model.entities.AppClient;
import com.krobusiness.model.entities.UserEntity;

public interface NotificationService {
    @Async
    void sendNotification(UserEntity userEntity);
}
