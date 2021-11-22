package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.Task;

import java.util.List;

public interface TasksRepository extends CrudRepository<Task, Integer> {
    Task findById(int id);
    List<Task> findAll();
}
