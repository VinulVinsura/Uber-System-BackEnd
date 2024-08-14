package com.example.driverservice.controller;

import com.example.driverservice.dto.AuthenticationResponse;
import com.example.driverservice.dto.DriverDto;
import com.example.driverservice.dto.LoginDetailsDto;
import com.example.driverservice.dto.SupportTicket;
import com.example.driverservice.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class DriverProfileController {
    private final DriverService driverService;


    @PostMapping("/drivers/register")

    //  Register a new driver.
    public ResponseEntity<AuthenticationResponse> registerDriver(@RequestBody DriverDto dto){
        AuthenticationResponse authenticationResponse = driverService.registerDriver(dto);
        return ResponseEntity.ok(authenticationResponse);
    }

    @PostMapping("/drivers/login")
    // Authenticate and login a driver
    public ResponseEntity<AuthenticationResponse> loginDriver(@RequestBody LoginDetailsDto loginDetailsDto){
        AuthenticationResponse response = driverService.loginDriver(loginDetailsDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/drivers/profile/{driverId}")
    //  Retrieve the driver's profile details.
    public ResponseEntity<DriverDto> getUserDetails(@PathVariable Integer driverId){
        DriverDto driverDto = driverService.getDriverDetails(driverId);
        if (driverDto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(driverDto);
    }

    @PostMapping("/drivers/support/ticket")

    public ResponseEntity<SupportTicket> addSupportTicket(@RequestBody SupportTicket supportTicket){
        SupportTicket ticket = driverService.addSupportTicket(supportTicket);
        return ResponseEntity.ok(ticket);

    }

    @GetMapping("/drivers/support/ticket/{userId}")

    public ResponseEntity<List<SupportTicket>> getAllSupportTicket(@PathVariable String userId){
        try {
            List<SupportTicket> supportTicketList = driverService.getAllSupportTicket(userId);
            return ResponseEntity.ok(supportTicketList);
        }catch (HttpClientErrorException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/drivers/support/ticket/{userId}/{ticketId}")
    public ResponseEntity<SupportTicket> getSupportTicketByTicketId(@PathVariable String userId,
                                                                    @PathVariable Integer ticketId){

        try {
            SupportTicket supportTicket = driverService.getSupportTicketByTicketId(userId, ticketId);
            return ResponseEntity.ok(supportTicket);
        }catch (HttpClientErrorException ex){
            return ResponseEntity.notFound().build();
        }

    }






}
