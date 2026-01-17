package com.duranunverdi.starter.jwt;

import com.duranunverdi.starter.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    // Secret key (örnek, production için güçlü key kullan)
    private static final String SECRET_KEY = "mySuperSecretKey12345";

    // Token süresi (1 saat)
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    // Token oluştur
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername()) // username'i subject olarak ekliyoruz
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    // Token geçerli mi?
    public boolean isTokenValid(String token, User user) {
        String username = getUserByToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    // Token'dan username al
    public String getUserByToken(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Token süresi dolmuş mu?
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // Tüm claimleri al
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }
}
