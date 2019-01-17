package com.evanslaton.healthtrackerbackend.exercise;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepo;

    @GetMapping(value="/exercises")
    public String getExercises() {
        Gson gson = new Gson();
        String exercisesJson = gson.toJson(exerciseRepo.findAll()); // Turns exercises into json

        return exercisesJson;
    }

    @PostMapping(value="/exercises")
    public Exercise addExercise(@RequestParam String title,
                       @RequestParam String quantity,
                       @RequestParam String description) {

        Exercise newExercise = new Exercise(title, Integer.parseInt(quantity), description);
        return exerciseRepo.save(newExercise);
    }
}
