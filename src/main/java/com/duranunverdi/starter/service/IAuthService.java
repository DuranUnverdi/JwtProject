package com.duranunverdi.starter.service;

import com.duranunverdi.starter.dto.DtoUser;
import com.duranunverdi.starter.jwt.AuthRequest;
import com.duranunverdi.starter.jwt.AuthResponse;

public interface IAuthService {
    public DtoUser registerNewUser(AuthRequest request);
    public AuthResponse authenticateUser (AuthRequest request);
}
