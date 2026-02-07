package com.duranunverdi.controller.impl;

import com.duranunverdi.controller.IRestAuthController;
import com.duranunverdi.dto.DtoUser;
import com.duranunverdi.jwt.AuthRequest;
import com.duranunverdi.jwt.AuthResponse;
import com.duranunverdi.jwt.RefreshTokenRequest;
import com.duranunverdi.service.IAuthService;
import com.duranunverdi.service.IRefreshTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

