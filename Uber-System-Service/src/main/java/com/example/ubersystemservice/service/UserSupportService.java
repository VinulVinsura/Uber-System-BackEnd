package com.example.ubersystemservice.service;

import com.example.ubersystemservice.dto.SupportTicketsDto;
import com.example.ubersystemservice.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserSupportService {
    SupportTicketsDto postSupportTicket(SupportTicketsDto ticketsDto);
    List<SupportTicketsDto> getSupportTickets(String userId, UserRole userRole);
    SupportTicketsDto getSupportTicketsByTicketId(String userId ,Integer ticketId, UserRole userRole);

}
