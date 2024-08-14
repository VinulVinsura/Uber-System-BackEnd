package com.example.passengerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {
    private Integer id;
    private String where_you;
    private String where_to;
    private Integer passengerId;

}
