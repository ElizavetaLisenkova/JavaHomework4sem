package com.example.onlineShop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String hashedPassword;
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;

}
