package com.evanslaton.healthtrackerbackend.applicationuser;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
}
