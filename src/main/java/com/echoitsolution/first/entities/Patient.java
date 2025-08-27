package com.echoitsolution.first.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
