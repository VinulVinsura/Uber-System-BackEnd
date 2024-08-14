package com.example.ubersystemservice.service;

import com.example.ubersystemservice.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    NotificationDto postNotification(NotificationDto Dto);
    List<NotificationDto> getAllNotification();
}
