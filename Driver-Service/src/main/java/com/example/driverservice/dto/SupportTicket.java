package com.example.driverservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportTicket {
    private Integer ticketId;
    private String postDate;
    private String description;
    private String userId;
    private String email;
    private String userName;
    private String phoneNumber;
    private String userRole;
}
