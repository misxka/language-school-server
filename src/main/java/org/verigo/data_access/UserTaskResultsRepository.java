package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.user_task_result.UserTaskResult;
import org.verigo.models.user_task_result.UserTaskKey;

import java.util.List;

public interface UserTaskResultsRepository extends CrudRepository<UserTaskResult, UserTaskKey> {
    List<UserTaskResult> findAll();
}
