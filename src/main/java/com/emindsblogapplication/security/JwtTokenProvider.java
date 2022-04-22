package com.emindsblogapplication.security;

import com.emindsblogapplication.exception.NotFoundException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JwtTokenProvider {

    @Value("${secret}")
    private String jwtSecret;

    @Value("${jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;


    // generate token

    public String generateToken(Authentication authentication){

        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationInMs);

        String token  = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        return token;
    }


    //get username from token

    public String getUsernameFromJwt(String token){

        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();

    }

    //validate jwt token

    public boolean  validateToken(String token) throws NotFoundException {
       try {
           Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
           return true;
       }
       catch (SignatureException ex){
          throw  new NotFoundException(HttpStatus.BAD_REQUEST,"Invalid Jwt Signature") ;
       }
       catch (MalformedJwtException ex){
           throw  new NotFoundException(HttpStatus.BAD_REQUEST,"Invalid Jwt Signature") ;
       }
       catch (ExpiredJwtException ex){
           throw  new NotFoundException(HttpStatus.BAD_REQUEST,"Expired Jwt Signature") ;
       }
       catch (UnsupportedJwtException ex){
           throw  new NotFoundException(HttpStatus.BAD_REQUEST,"Unsupported Jwt Signature") ;
       }
       catch (IllegalArgumentException ex){
           throw  new NotFoundException(HttpStatus.BAD_REQUEST,"jwt Is claims String Is Empty ") ;
       }

    }
}
