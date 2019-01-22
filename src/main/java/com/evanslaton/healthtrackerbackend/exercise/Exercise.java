package com.evanslaton.healthtrackerbackend.exercise;

import com.evanslaton.healthtrackerbackend.applicationuser.ApplicationUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String title;
    public int quantity;
    public String description;
    public String timestamp;
    public String latitude;
    public String longitude;

    // Database Relationship(s)
    @ManyToOne
    public ApplicationUser applicationUser;

    // Default constructor
    public Exercise() {};

    // Constructor
    public Exercise(String title, int quantity, String description, String latitude, String longitude) {
        this.title = title;
        this.quantity = quantity;
        this.description = description;
        this.timestamp = new Date().toString();
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
