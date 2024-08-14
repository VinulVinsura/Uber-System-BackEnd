package com.example.driverservice.service;

import com.example.driverservice.entity.Driver;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY="426f4cbeea18d5d5860b6809c087bf8be40c175f380cbcfde7ff77617df591c7";

    public String generateToke(Driver driver){
        String token= Jwts.
                builder()
                .subject(driver.getUsername())
                .claim("id",driver.getDriverId())
                .claim("DriverName",driver.getName())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*60*24*1000))
                .signWith(getSignKey())
                .compact();
        return token;
    }

    private SecretKey getSignKey(){
        byte[] decode = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decode);
    }

    public boolean isValid(String token, UserDetails driver){
        String userName=extractUserName(token);
        return (userName.equals(driver.getUsername())) && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public String extractUserName(String token){
        return extractClaims(token, Claims::getSubject);
    }
    public <T> T extractClaims(String token , Function<Claims,T> resolver){
        Claims claims=extractAllClaims(token);
        return resolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    private Date extractExpiration(String token){
        return extractClaims(token, Claims::getExpiration);

    }

}
