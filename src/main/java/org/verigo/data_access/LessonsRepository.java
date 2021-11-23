package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.Lesson;

import java.util.List;

public interface LessonsRepository extends CrudRepository<Lesson, Integer> {
    List<Lesson> findAll();
}
