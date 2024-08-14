package com.example.driverservice.service;

import com.example.driverservice.dto.AuthenticationResponse;
import com.example.driverservice.dto.DriverDto;
import com.example.driverservice.dto.LoginDetailsDto;
import com.example.driverservice.dto.SupportTicket;

import java.util.List;

public interface DriverService {

    AuthenticationResponse registerDriver(DriverDto dto);
    AuthenticationResponse loginDriver(LoginDetailsDto loginDetailsDto);
    DriverDto getDriverDetails(Integer driverId);
    SupportTicket addSupportTicket(SupportTicket supportTicket);

    List<SupportTicket> getAllSupportTicket(String  userId);

    SupportTicket getSupportTicketByTicketId(String userId, Integer ticketId);
}

