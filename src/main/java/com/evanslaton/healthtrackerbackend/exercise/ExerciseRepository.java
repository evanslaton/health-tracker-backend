package com.evanslaton.healthtrackerbackend.exercise;

import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long>  {
    public Exercise findById(long id);
}
