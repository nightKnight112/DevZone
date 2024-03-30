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
@Table(name="Follows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followId;

    @Column
    private Integer followingUserId;

    @Column
    private Integer followedUserId;

    @Column
    private String timestamp;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User users;
}
