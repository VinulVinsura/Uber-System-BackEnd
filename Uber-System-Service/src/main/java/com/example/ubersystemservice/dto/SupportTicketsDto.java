package com.example.ubersystemservice.dto;

import com.example.ubersystemservice.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportTicketsDto {

    private Integer ticketId;
    private String postDate;
    private String description;
    private String userId;
    private String email;
    private String userName;
    private String phoneNumber;
    private UserRole userRole;
}
