package com.example.passengerservice.repository;

import com.example.passengerservice.entity.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRequestRepo extends JpaRepository<RideRequest,Integer> {
    RideRequest findByPassengerIdAndId(Integer passengerId,
                                       Integer rideId);
    List<RideRequest> findAllByPassengerId(Integer passengerId);
}
