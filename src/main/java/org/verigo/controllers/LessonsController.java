package org.verigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.CoursesRepository;
import org.verigo.data_access.LessonsRepository;
import org.verigo.models.Course;
import org.verigo.models.Lesson;

import java.util.List;

@RestController
@RequestMapping(path = "/lessons")
public class LessonsController {

    @Autowired
    private LessonsRepository lessonsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping
    List<Lesson> getLessons() {
        return lessonsRepository.findAll();
    }

    @PostMapping
    Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonsRepository.save(lesson);
    }

    @PutMapping("/{lessonId}/course/{courseId}")
    Lesson assignLessonToCourse(
            @PathVariable int lessonId,
            @PathVariable int courseId
    ) {
        Lesson lesson = lessonsRepository.findById(lessonId).get();
        Course course = coursesRepository.findById(courseId).get();
        lesson.setCourse(course);
        return lessonsRepository.save(lesson);
    }
}
