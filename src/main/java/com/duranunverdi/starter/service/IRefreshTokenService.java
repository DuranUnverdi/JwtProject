package com.duranunverdi.starter.service;

import com.duranunverdi.starter.jwt.AuthResponse;
import com.duranunverdi.starter.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {
    public AuthResponse refreshAccessToken(RefreshTokenRequest request);
}
