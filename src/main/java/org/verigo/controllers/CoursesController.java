package org.verigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.CoursesRepository;
import org.verigo.models.Course;
import org.verigo.models.Task;

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

    @DeleteMapping("/{id}")
    Optional<Course> deleteCourse(@PathVariable int id) {
        try {
            Optional<Course> course = coursesRepository.findById(id);
            coursesRepository.deleteById(id);
            return course;
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
}
