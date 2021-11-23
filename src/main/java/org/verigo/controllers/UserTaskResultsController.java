package org.verigo.controllers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.verigo.data_access.TasksRepository;
import org.verigo.data_access.UserTaskResultsRepository;
import org.verigo.data_access.UsersRepository;
import org.verigo.models.Task;
import org.verigo.models.User;
import org.verigo.models.user_task_result.UserTaskKey;
import org.verigo.models.user_task_result.UserTaskResult;

@RestController
@RequestMapping(path = "/results")
public class UserTaskResultsController {

    @Autowired
    private UserTaskResultsRepository resultsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @PostMapping
    UserTaskResult createAssociation(@RequestBody PostBody body) {
        Task task = tasksRepository.findById(body.getTaskId()).get();
        User user = usersRepository.findById(body.getUserId());
        UserTaskKey key = new UserTaskKey(body.getUserId(), body.getTaskId());
        UserTaskResult userTaskResult = new UserTaskResult(key, user, task);
        return resultsRepository.save(userTaskResult);
    }

    @PutMapping("/task/{taskId}/user/{userId}")
    UserTaskResult assignPoints(
        @PathVariable int taskId,
        @PathVariable int userId,
        @RequestBody PutBody body
    ) {
        UserTaskKey key = new UserTaskKey(userId, taskId);
        UserTaskResult result = resultsRepository.findById(key).get();
        result.setPoints(body.getPoints());
        result.setCompleted(true);
        return resultsRepository.save(result);
    }
}

class PostBody {
    private int taskId;
    private int userId;

    PostBody(int userId, int taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }


    public int getUserId() {
        return userId;
    }

    public int getTaskId() {
        return taskId;
    }
}

class PutBody {
    private int points;

    @JsonCreator
    PutBody(@JsonProperty int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}