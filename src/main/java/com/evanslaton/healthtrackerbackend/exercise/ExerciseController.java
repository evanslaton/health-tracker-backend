package com.evanslaton.healthtrackerbackend.exercise;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
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
    public void addExercise(@RequestParam String title,
                       @RequestParam int quantity,
                       @RequestParam String description) {

        Exercise newExercise = new Exercise(title, quantity, description);
        exerciseRepo.save(newExercise);
    }
}
