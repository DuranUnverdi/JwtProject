package com.duranunverdi.service;

import com.duranunverdi.dto.DtoUser;
import com.duranunverdi.jwt.AuthRequest;
import com.duranunverdi.model.RefreshToken;
import com.duranunverdi.model.User;
import com.duranunverdi.repository.RefreshTokenRepository;
import com.duranunverdi.repository.UserRepository;
import com.duranunverdi.jwt.AuthResponse;
import com.duranunverdi.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;
    private final JwtService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public DtoUser registerNewUser(AuthRequest request) {
        DtoUser dtoUser = new DtoUser();
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(newUser);
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }
    private RefreshToken createAndSaveRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
        refreshToken.setUser(user);
        return refreshToken;

    }

    @Override
    public AuthResponse authenticateUser(AuthRequest request) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                );

        authenticationProvider.authenticate(authToken);

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken = createAndSaveRefreshToken(user);
        refreshTokenRepository.save(refreshToken);
        return new AuthResponse(accessToken, refreshToken.getRefreshToken());
    }


}
