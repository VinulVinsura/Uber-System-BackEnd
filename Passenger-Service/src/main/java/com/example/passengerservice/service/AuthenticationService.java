package com.example.passengerservice.service;

import com.example.passengerservice.repository.PassengerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final PassengerRepo passengerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return passengerRepo.findByEmail(username).
                orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
    }
}
