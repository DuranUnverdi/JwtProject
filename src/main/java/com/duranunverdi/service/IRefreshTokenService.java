package com.duranunverdi.service;

import com.duranunverdi.jwt.RefreshTokenRequest;
import com.duranunverdi.jwt.AuthResponse;

public interface IRefreshTokenService {
    public AuthResponse refreshAccessToken(RefreshTokenRequest request);
}
