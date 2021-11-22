package org.verigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.LessonsRepository;
import org.verigo.models.Lesson;

import java.util.List;

@RestController
@RequestMapping(path = "/lessons")
public class LessonsController {

    @Autowired
    private LessonsRepository lessonsRepository;

    @GetMapping
    List<Lesson> getLessons() {
        return lessonsRepository.findAll();
    }

    @PostMapping
    Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonsRepository.save(lesson);
    }
}
