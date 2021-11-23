package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.CourseGroup;

import java.util.List;

public interface CourseGroupsRepository extends CrudRepository<CourseGroup, Integer> {
    List<CourseGroup> findAll();
}
