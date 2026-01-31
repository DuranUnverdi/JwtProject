package com.duranunverdi.starter.controller.impl;

import com.duranunverdi.starter.controller.IRestAuthController;
import com.duranunverdi.starter.dto.DtoUser;
import com.duranunverdi.starter.jwt.AuthRequest;
import com.duranunverdi.starter.jwt.AuthResponse;
import com.duranunverdi.starter.jwt.RefreshTokenRequest;
import com.duranunverdi.starter.service.IAuthService;
import com.duranunverdi.starter.service.IRefreshTokenService;
import com.duranunverdi.starter.service.RefreshTokenServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestAuthControllerImpl implements IRestAuthController {

    private final IAuthService authService;
    private final IRefreshTokenService refreshTokenService;



    @Override
    @PostMapping("/register")
    public DtoUser registerNewUser(@RequestBody @Valid AuthRequest authRequest) {
        return authService.registerNewUser(authRequest);
    }

    @Override
    @PostMapping("/authenticate")
    public AuthResponse authenticateUser(@RequestBody @Valid AuthRequest authRequest) {
        return authService.authenticateUser(authRequest);
    }

    @Override
    @PostMapping("/refresh-token")
    public AuthResponse refreshAccessToken(@RequestBody RefreshTokenRequest request) {
        return refreshTokenService.refreshAccessToken(request);
    }

}

