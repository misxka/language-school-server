package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.Course;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Course, Integer> {
    List<Course> findAll();
}
