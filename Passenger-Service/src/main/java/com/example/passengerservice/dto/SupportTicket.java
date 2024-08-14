package com.example.passengerservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
