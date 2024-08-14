package com.example.driverservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private Integer driverId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
}
