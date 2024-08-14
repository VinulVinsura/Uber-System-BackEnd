package com.example.passengerservice.controller;

import com.example.passengerservice.dto.AuthenticationResponse;
import com.example.passengerservice.dto.LoginDto;
import com.example.passengerservice.dto.PassengerDto;
import com.example.passengerservice.dto.SupportTicket;
import com.example.passengerservice.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProfileManagementController {
    private final PassengerService passengerService;

    // Register a new passenger
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerPassenger(@RequestBody PassengerDto passengerDto){
        AuthenticationResponse autheResponse = passengerService.registerPassenger(passengerDto);
        return ResponseEntity.ok(autheResponse);
    }

    // Authenticate and login a passenger.
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginPassenger(@RequestBody LoginDto loginDto){
        AuthenticationResponse response = passengerService.loginPassenger(loginDto);
        return ResponseEntity.ok(response);
    }

    // Retrieve passenger profile details
    @GetMapping("/getPassengerById/{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable Integer id){
        PassengerDto passengerDto = passengerService.getPassenger(id);
        return ResponseEntity.ok(passengerDto);
    }

    // Retrieve all notifications for the passenger.
    @GetMapping("/passenger/notification")
    public ResponseEntity<List> getNotification(){
        ResponseEntity<List> notification = passengerService.getNotification();
        return ResponseEntity.ok(notification.getBody());

    }

    //Create a new support ticket
    @PostMapping("/post-support-ticket")
    public ResponseEntity<SupportTicket> postSupportTicket(@RequestBody SupportTicket supportTicket){
        SupportTicket ticket = passengerService.postSupportTicket(supportTicket);
        return ResponseEntity.ok(ticket);
    }

    // List all support tickets for the passenger
    @GetMapping("/getAll-support-tickets/{userId}")
    public ResponseEntity<List> getSupportTicketById(@PathVariable String userId){
        try {
            return  passengerService.getSupportTicketByUserId(userId);
        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }


    }

    // Get details of a specific support ticket.
    @GetMapping("/get-support-tickets/{userId}/{ticketId}")
    public ResponseEntity<SupportTicket> getSupportTicketByTicketId(@PathVariable String userId,
                                                                    @PathVariable Integer ticketId){
        SupportTicket ticket = passengerService.getSupportTicketByTicketId(userId, ticketId);
        return ResponseEntity.ok(ticket);

    }


}
