package com.example.ubersystemservice.repository;

import com.example.ubersystemservice.entity.SupportTicket;
import com.example.ubersystemservice.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportTicketRepo extends JpaRepository<SupportTicket, Integer> {
    List<SupportTicket> findAllByUserIdAndUserRole(String userId, UserRole userRole);
    SupportTicket findByUserIdAndTicketIdAndUserRole(String userId ,Integer ticketId,UserRole userRole);
}
