package com.jobapp.model;

import com.jobapp.model.JobRequest;
import com.jobapp.model.Bid;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role; // "customer" or "provider"

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<JobRequest> jobRequests;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Bid> bids;

    public User() {}

    // Getters and setters...
}