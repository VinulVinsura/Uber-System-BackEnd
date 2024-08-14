package com.example.passengerservice.service;

import com.example.passengerservice.dto.AuthenticationResponse;
import com.example.passengerservice.dto.LoginDto;
import com.example.passengerservice.dto.PassengerDto;
import com.example.passengerservice.dto.SupportTicket;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public interface PassengerService {

    AuthenticationResponse registerPassenger(PassengerDto passengerDto);
    AuthenticationResponse loginPassenger(LoginDto loginDto);
    PassengerDto getPassenger(Integer id);
    ResponseEntity<List> getNotification();
    SupportTicket postSupportTicket(SupportTicket supportTicket);
    ResponseEntity<List> getSupportTicketByUserId(String userId);
    SupportTicket getSupportTicketByTicketId(String userId, Integer ticketId);
}
