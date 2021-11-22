package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.user_task.UserTask;

public interface UserTaskRepository extends CrudRepository<UserTask, Integer> {

}
