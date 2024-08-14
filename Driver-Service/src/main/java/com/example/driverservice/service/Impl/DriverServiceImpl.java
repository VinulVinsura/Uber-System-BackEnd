package com.example.driverservice.service.Impl;

import com.example.driverservice.dto.AuthenticationResponse;
import com.example.driverservice.dto.DriverDto;
import com.example.driverservice.dto.LoginDetailsDto;
import com.example.driverservice.dto.SupportTicket;
import com.example.driverservice.entity.Driver;
import com.example.driverservice.repository.DriverRepo;
import com.example.driverservice.service.DriverService;
import com.example.driverservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepo driverRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RestTemplate restTemplate;
    @Override
    public AuthenticationResponse registerDriver(DriverDto dto) {
        Driver driver=new Driver();
        driver.setName(dto.getName());
        driver.setEmail(dto.getEmail());
        driver.setAddress(dto.getAddress());
        driver.setPhoneNumber(dto.getPhoneNumber());
        driver.setPassword(passwordEncoder.encode(dto.getPassword()));
        Driver saveDrive = driverRepo.save(driver);
        String toke = jwtService.generateToke(saveDrive);
        return new AuthenticationResponse(toke);


    }

    @Override
    public AuthenticationResponse loginDriver(LoginDetailsDto loginDetailsDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDetailsDto.getEmail(),
                        loginDetailsDto.getPassword()
                )
        );
        Driver driver = driverRepo.findByEmail(loginDetailsDto.getEmail()).orElseThrow();
        String toke = jwtService.generateToke(driver);

        return new AuthenticationResponse(toke);
    }

    @Override
    public DriverDto getDriverDetails(Integer driverId) {
       return modelMapper.map(driverRepo.findById(driverId), DriverDto.class);

    }

    @Override
    public SupportTicket addSupportTicket(SupportTicket supportTicket) {
        String url="http://localhost:9001/post/support-ticket";
        HttpEntity<SupportTicket> httpEntity =new HttpEntity<>(supportTicket);
        ResponseEntity<SupportTicket> response = restTemplate.postForEntity(url, httpEntity, SupportTicket.class);

        return response.getBody();
    }

    @Override
    public List getAllSupportTicket(String userId) {

        String url="http://localhost:9001/getAll-support-ticket/"+userId+"/Driver";
        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
        return response.getBody();
    }

    @Override
    public SupportTicket getSupportTicketByTicketId(String userId, Integer ticketId) {

        String url="http://localhost:9001/get-support-ticket/"+userId+"/"+ticketId+"/Driver";
        ResponseEntity<SupportTicket> response = restTemplate.getForEntity(url, SupportTicket.class);
        return response.getBody();
    }
}
