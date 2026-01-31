package com.duranunverdi.starter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "refresh_tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "refresh_token", nullable = false, unique = true)
    private String refreshToken;
    @Column(name = "expiry_date", nullable = false)
    private Date expiryDate;
    @ManyToOne
    private User user;
}
