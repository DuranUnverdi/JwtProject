package com.duranunverdi.starter.controller;

import com.duranunverdi.starter.dto.DtoUser;
import com.duranunverdi.starter.jwt.AuthRequest;
import com.duranunverdi.starter.jwt.AuthResponse;

public interface IRestAuthController {
    public DtoUser registerNewUser(AuthRequest authRequest);
    public AuthResponse authenticateUser(AuthRequest authRequest);

}
