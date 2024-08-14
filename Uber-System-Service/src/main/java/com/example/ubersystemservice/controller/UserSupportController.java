package com.example.ubersystemservice.controller;

import com.example.ubersystemservice.dto.SupportTicketsDto;
import com.example.ubersystemservice.entity.UserRole;
import com.example.ubersystemservice.service.UserSupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserSupportController {
    private final UserSupportService userSupportService;

    @PostMapping("/post/support-ticket")
    public ResponseEntity<SupportTicketsDto> postSupportTicket(@RequestBody SupportTicketsDto dto){
        SupportTicketsDto ticketsDto = userSupportService.postSupportTicket(dto);
        return ResponseEntity.ok(ticketsDto);
    }

    //List all support tickets for the passenger.
    @GetMapping("/getAll-support-ticket/{userId}/{userRole}")
    public ResponseEntity<List<SupportTicketsDto>> getSupportTicketById(@PathVariable String userId,
                                                                        @PathVariable UserRole userRole ){
        System.out.println(1);
        List<SupportTicketsDto> ticketsDtoList = userSupportService.getSupportTickets(userId,userRole);
        if (ticketsDtoList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticketsDtoList);

    }

    // Get details of a specific support ticket.
    @GetMapping("/get-support-ticket/{userId}/{ticketId}/{userRole}")
    public ResponseEntity<SupportTicketsDto> getSupportTicketByTicketId(@PathVariable String userId,
                                                                        @PathVariable Integer ticketId,
                                                                        @PathVariable UserRole userRole){
        try {
            SupportTicketsDto tickets = userSupportService.getSupportTicketsByTicketId(userId, ticketId,userRole);
            return ResponseEntity.ok(tickets);
        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }

    }
}
