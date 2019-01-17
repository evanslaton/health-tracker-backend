package com.evanslaton.healthtrackerbackend.exercise;

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

    // Default constructor
    public Exercise() {};

    // Constructor
    public Exercise(String title, int quantity, String description) {
        this.title = title;
        this.quantity = quantity;
        this.description = description;
        this.timestamp = new Date().toString();
    }
}
