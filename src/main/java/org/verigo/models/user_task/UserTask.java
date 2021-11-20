package org.verigo.models.user_task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.verigo.models.Task;
import org.verigo.models.User;

import javax.persistence.*;

@Entity(name = "user_task")
public class UserTask {
    @EmbeddedId
    UserTaskKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    private int points;


    @JsonCreator
    public UserTask(
            @JsonProperty("user") User user,
            @JsonProperty("task") Task task,
            @JsonProperty("points") int points
    ) {
        this.user = user;
        this.task = task;
        this.points = points;
    }

    @JsonCreator
    public UserTask() {

    }


    public UserTask update(UserTask userTask) {
        this.user = userTask.user;
        this.task = userTask.task;
        this.points = userTask.points;

        return this;
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
}
