package org.verigo.models.user_task_result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.verigo.models.Task;
import org.verigo.models.User;

import javax.persistence.*;

@Entity(name = "user_task_result")
public class UserTaskResult {
    @EmbeddedId
    UserTaskKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id", nullable = false)
    @JsonIgnore
    private Task task;

    private int points;

    @Column(name = "is_completed", columnDefinition = "TINYINT(1)")
    private boolean isCompleted;

    public UserTaskResult() {

    }

    public UserTaskResult(UserTaskKey id, User user, Task task) {
        this.id = id;
        this.user = user;
        this.task = task;
        this.isCompleted = false;
    }

    public UserTaskResult(UserTaskKey id, User user, Task task, int points) {
        this.id = id;
        this.user = user;
        this.task = task;
        this.points = points;
        this.isCompleted = true;
    }


    public Task getTask() {
        return task;
    }

    public User getUser() {
        return user;
    }

    public int getPoints() {
        return points;
    }

    public UserTaskKey getId() {
        return id;
    }

    @JsonProperty(value = "isCompleted")
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setId(UserTaskKey id) {
        this.id = id;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}