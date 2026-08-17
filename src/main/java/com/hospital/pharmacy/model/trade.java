package com.hospital.pharmacy.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class trade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    @Column
    private String name;

    @Column
    private String description;
}
