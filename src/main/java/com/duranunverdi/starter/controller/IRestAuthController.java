package com.duranunverdi.starter.controller;

import com.duranunverdi.starter.dto.DtoUser;
import com.duranunverdi.starter.jwt.AuthRequest;

public interface IRestAuthController {
    public DtoUser registerNewUser(AuthRequest authRequest);

}
