package com.poemese.poemese.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "POEMESE_USER")
public class User implements Serializable {
    @Id
    @Email
    @Column(nullable=false, unique = true)
    private String email;

    @Column
    @NotNull
    private String password;

    @Column(length=255)
    @NotNull
    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
}
