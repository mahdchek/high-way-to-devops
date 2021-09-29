package com.rte.highwaytodevops.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personne {

    @Id
    private Long id;
    private Long tjm;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
