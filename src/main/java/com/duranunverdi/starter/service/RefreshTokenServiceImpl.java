package com.duranunverdi.starter.service;

import com.duranunverdi.starter.jwt.AuthResponse;
import com.duranunverdi.starter.jwt.JwtService;
import com.duranunverdi.starter.jwt.RefreshTokenRequest;
import com.duranunverdi.starter.model.RefreshToken;
import com.duranunverdi.starter.model.User;
import com.duranunverdi.starter.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements IRefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;
    String accessToken;
    RefreshToken saveRefreshToken;

    public boolean isTokenExpired(RefreshToken refreshToken) {
        return refreshToken.getExpiryDate().before(new java.util.Date());
    }

    private RefreshToken createAndSaveRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setUser(user);
        return refreshToken;

    }


        @Override
        public AuthResponse refreshAccessToken(RefreshTokenRequest request) {

            RefreshToken refreshToken = refreshTokenRepository
                    .findByRefreshToken(request.getRefreshToken())
                    .orElseThrow(() -> new RuntimeException("Refresh token bulunamadı"));

            if (isTokenExpired(refreshToken)) {
                throw new RuntimeException("Refresh token süresi dolmuş");
            }

            User user = refreshToken.getUser();

            String accessToken = jwtService.generateToken(user);

            RefreshToken newRefreshToken =
                    refreshTokenRepository.save(createAndSaveRefreshToken(user));

            return new AuthResponse(accessToken, newRefreshToken.getRefreshToken());
        }

}
