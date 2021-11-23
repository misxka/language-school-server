package org.verigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.CourseGroupsRepository;
import org.verigo.data_access.CoursesRepository;
import org.verigo.data_access.UsersRepository;
import org.verigo.models.*;

import java.util.List;

@RestController
@RequestMapping(path = "/course-groups")
public class CourseGroupsController {

    @Autowired
    private CourseGroupsRepository courseGroupsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping
    List<CourseGroup> getGroups() {
        return courseGroupsRepository.findAll();
    }

    @PutMapping("/course/{courseId}")
    CourseGroup assignGroupToCourse(
        @PathVariable int courseId
    ) {
        Course course = coursesRepository.findById(courseId).get();
        CourseGroup group = new CourseGroup();
        group.setCourse(course);
        return courseGroupsRepository.save(group);
    }

    @PutMapping("/{groupId}/user/{userId}")
    CourseGroup assignUserToGroup(
        @PathVariable int groupId,
        @PathVariable int userId
    ) {
        CourseGroup group = courseGroupsRepository.findById(groupId).get();
        User user = usersRepository.findById(userId);
        group.addParticipants(user);
        return courseGroupsRepository.save(group);
    }
}
