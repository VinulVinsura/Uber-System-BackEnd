package com.example.ubersystemservice.service.Impl;

import com.example.ubersystemservice.dto.NotificationDto;
import com.example.ubersystemservice.entity.Notification;
import com.example.ubersystemservice.repository.NotificationRepo;
import com.example.ubersystemservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepo notificationRepo;
    private final ModelMapper modelMapper;
    @Override
    public NotificationDto postNotification(NotificationDto dto) {
        Notification notification=new Notification();
        notification.setPostDate(new Date());
        notification.setDescription(dto.getDescription());
        Notification savedNotification = notificationRepo.save(notification);
        return modelMapper.map(savedNotification, NotificationDto.class);
    }

    @Override
    public List<NotificationDto> getAllNotification() {
        List<Notification> notificationList = notificationRepo.findAll();
        return modelMapper.map(notificationList,new TypeToken<List<NotificationDto>>(){}.getType());
    }
}
