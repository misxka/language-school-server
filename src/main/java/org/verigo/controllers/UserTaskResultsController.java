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

import java.util.ArrayList;
import java.util.List;

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
    UserTaskResult createAssociation(@RequestBody PostSingleBody body) {
        Task task = tasksRepository.findById(body.getTaskId()).get();
        User user = usersRepository.findById(body.getUserId());
        UserTaskKey key = new UserTaskKey(body.getUserId(), body.getTaskId());
        UserTaskResult userTaskResult = new UserTaskResult(key, user, task);
        return resultsRepository.save(userTaskResult);
    }

    @PostMapping(path = "/multiple")
    List<UserTaskResult> createAssociations(@RequestBody PostMultipleBody body) {
        List<UserTaskResult> response = new ArrayList<>();
        int userId = body.getUserId();

        body.getTaskIds().forEach(taskId -> {
            Task task = tasksRepository.findById(taskId).get();
            User user = usersRepository.findById(userId);
            UserTaskKey key = new UserTaskKey(userId, taskId);
            UserTaskResult userTaskResult = new UserTaskResult(key, user, task);
            response.add(resultsRepository.save(userTaskResult));
        });

        return response;
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

class PostSingleBody {
    private int taskId;
    private int userId;

    PostSingleBody(int userId, int taskId) {
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

class PostMultipleBody {
    private List<Integer> taskIds;
    private int userId;

    PostMultipleBody(int userId, List<Integer> taskIds) {
        this.userId = userId;
        this.taskIds = taskIds;
    }


    public int getUserId() {
        return userId;
    }

    public List<Integer> getTaskIds() {
        return taskIds;
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