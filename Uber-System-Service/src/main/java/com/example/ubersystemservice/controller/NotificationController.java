package com.example.ubersystemservice.controller;

import com.example.ubersystemservice.dto.NotificationDto;
import com.example.ubersystemservice.entity.Notification;
import com.example.ubersystemservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/post-notification")
    public ResponseEntity<NotificationDto> postNotification(@RequestBody NotificationDto notificationDto){
        NotificationDto dto = notificationService.postNotification(notificationDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/all-notifications")
    public ResponseEntity<List<NotificationDto>> getAllNotifications(){
        List<NotificationDto> notificationDtoList = notificationService.getAllNotification();
        return ResponseEntity.ok(notificationDtoList);
    }
}
