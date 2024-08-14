package com.example.ubersystemservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    private Integer NoteId;
    private Date postDate;
    private String description;
}
