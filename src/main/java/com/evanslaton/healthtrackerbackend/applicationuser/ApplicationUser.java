package com.evanslaton.healthtrackerbackend.applicationuser;

import com.evanslaton.healthtrackerbackend.exercise.Exercise;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(unique = true)
    public String username;
    public String password;

    // Database Relationship(s)
    @OneToMany(mappedBy="applicationUser", fetch=FetchType.EAGER)
    public List<Exercise> exercises;

    // Default constructor
    public ApplicationUser() {}

    // Constructor
    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.exercises = new ArrayList<Exercise>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
