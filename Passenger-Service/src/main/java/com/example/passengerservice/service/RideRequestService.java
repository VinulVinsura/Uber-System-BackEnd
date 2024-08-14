package com.example.passengerservice.service;

import com.example.passengerservice.dto.AuthenticationResponse;
import com.example.passengerservice.dto.RideRequestDto;

import java.util.List;

public interface RideRequestService {
    RideRequestDto requestRide(RideRequestDto dto);
    RideRequestDto getSpecificRide(Integer passengerId,
                                   Integer RideId);

    List<RideRequestDto> getAllRideByPassengerId(Integer passengerId);
}
