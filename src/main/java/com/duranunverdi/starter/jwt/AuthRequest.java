package com.duranunverdi.starter.jwt;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

}
