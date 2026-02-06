package com.duranunverdi.controller;

import com.duranunverdi.dto.DtoUser;
import com.duranunverdi.jwt.AuthRequest;
import com.duranunverdi.jwt.AuthResponse;
import com.duranunverdi.jwt.RefreshTokenRequest;

public interface IRestAuthController {
    public DtoUser registerNewUser(AuthRequest authRequest);
    public AuthResponse authenticateUser(AuthRequest authRequest);
    public AuthResponse refreshAccessToken(RefreshTokenRequest request);

}
