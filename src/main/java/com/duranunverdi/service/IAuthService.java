package com.duranunverdi.service;

import com.duranunverdi.dto.DtoUser;
import com.duranunverdi.jwt.AuthRequest;
import com.duranunverdi.jwt.AuthResponse;

public interface IAuthService {
    public DtoUser registerNewUser(AuthRequest request);
    public AuthResponse authenticateUser (AuthRequest request);
}
