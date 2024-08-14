package com.example.ubersystemservice.repository;

import com.example.ubersystemservice.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification,Integer> {
}
