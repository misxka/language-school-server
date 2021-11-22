package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.CourseGroup;

import java.util.List;

public interface CourseGroupsRepository extends CrudRepository<CourseGroup, Integer> {
    CourseGroup findById(int id);
    CourseGroup findByCourseId(int courseId);
    List<CourseGroup> findAll();
}
