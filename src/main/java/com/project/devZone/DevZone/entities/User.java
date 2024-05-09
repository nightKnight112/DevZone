package com.project.devZone.DevZone.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userId", unique = true)
    @NotEmpty(message = "userId cannot be empty")
    private Integer userId;

    @NotEmpty(message="Username cannot be null")
    @Length(min=10, max=40, message="username must be between 10 to 40 characters")
    @Column(unique=true)
    private String userName;

    @Email(message="Please enter valid email")
    @Column(unique=true)
    @NotEmpty
    private String email;

    @Length(min = 10, message="phone number must be 10 digits")
    @Column(unique = true)
    @NotEmpty(message = "please provide a phone number")
    private String phoneNo;

    @Column
    @NotBlank(message="password field cannot be empty")
    private String password;

    @Column
    private String role;

    @Column(name = "created_at")
    private String timestamp;

    @Column(name = "is_active")
    private Boolean status;

    @Column(name = "kudos_earned")
    private Integer kudosEarned;

    @Column
    private Integer followers;

    @Column(name = "active_count")
    private Integer activeCount;

    @Column
    private Integer rating;

    @Column
    private String profileUrls;

    @OneToMany(mappedBy = "users")
    private List<Follows> follows;

    @OneToMany(mappedBy = "users")
    private List<Comments> comments;



}
