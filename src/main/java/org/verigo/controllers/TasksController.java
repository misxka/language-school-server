package org.verigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.LessonsRepository;
import org.verigo.data_access.TasksRepository;
import org.verigo.models.Lesson;
import org.verigo.models.Task;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class TasksController {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private LessonsRepository lessonsRepository;

    @GetMapping
    List<Task> getTasks() {
        return tasksRepository.findAll();
    }

    @PostMapping
    Task createTask(@RequestBody Task task) {
        return tasksRepository.save(task);
    }

    @PutMapping("/{taskId}/lesson/{lessonId}")
    Task assignTaskToLesson(
            @PathVariable int taskId,
            @PathVariable int lessonId
    ) {
        Task task = tasksRepository.findById(taskId).get();
        Lesson lesson = lessonsRepository.findById(lessonId).get();
        task.setLesson(lesson);
        return tasksRepository.save(task);
    }
}
