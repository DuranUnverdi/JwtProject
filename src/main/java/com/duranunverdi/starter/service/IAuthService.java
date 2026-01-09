package com.duranunverdi.starter.service;

import com.duranunverdi.starter.dto.DtoUser;
import com.duranunverdi.starter.jwt.AuthRequest;

public interface IAuthService {
    public DtoUser registerNewUser(AuthRequest request);
}
