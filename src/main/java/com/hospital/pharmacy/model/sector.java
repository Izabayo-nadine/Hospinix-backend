package com.hospital.pharmacy.model;


import jakarta.persistence.*;

import java.util.*;

public class sector {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    @Column
    private String name;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sector")
    private List<trade>  trades;


}