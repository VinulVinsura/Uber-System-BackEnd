package com.example.driverservice.repository;

import com.example.driverservice.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepo extends JpaRepository<Driver,Integer> {
    Optional<Driver> findByEmail(String userName);
}
