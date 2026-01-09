package com.duranunverdi.starter.service;

import com.duranunverdi.starter.dto.DtoUser;
import com.duranunverdi.starter.jwt.AuthRequest;
import com.duranunverdi.starter.model.User;
import com.duranunverdi.starter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public DtoUser registerNewUser(AuthRequest request) {
        DtoUser dtoUser = new DtoUser();
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
       User savedUser= userRepository.save(newUser);
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }
}
