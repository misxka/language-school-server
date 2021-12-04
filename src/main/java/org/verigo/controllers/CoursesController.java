package org.verigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.CoursesRepository;
import org.verigo.models.Course;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/courses")
public class CoursesController {

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping(path = "/{id}")
    Optional<Course> getCourseById(@PathVariable int id) {
        return coursesRepository.findById(id);
    }

    @GetMapping
    List<Course> getCourses() {
        return coursesRepository.findAll();
    }

    @PostMapping
    Course createCourse(@RequestBody Course course) {
        return coursesRepository.save(course);
    }
}
