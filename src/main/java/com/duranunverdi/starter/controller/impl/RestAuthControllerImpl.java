package com.duranunverdi.starter.controller.impl;

import com.duranunverdi.starter.controller.IRestAuthController;
import com.duranunverdi.starter.dto.DtoUser;
import com.duranunverdi.starter.jwt.AuthRequest;
import com.duranunverdi.starter.service.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {

    private final IAuthService authService;

    public RestAuthControllerImpl(IAuthService authService) {
        this.authService = authService;
    }

    @Override
    @PostMapping("/authenticate")
    public DtoUser registerNewUser(@RequestBody @Valid AuthRequest authRequest) {
        return authService.registerNewUser(authRequest);
    }

}

