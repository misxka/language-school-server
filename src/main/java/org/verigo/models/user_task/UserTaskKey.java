package org.verigo.models.user_task;

import org.verigo.models.User;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserTaskKey implements Serializable {
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "task_id", nullable = false)
    private Integer taskId;

    public UserTaskKey(Integer userId, Integer taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }

    public UserTaskKey() {

    }


    public Integer getUserId() {
        return userId;
    }

    public Integer getTaskId() {
        return taskId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTaskKey)) return false;
        UserTaskKey that = (UserTaskKey) o;
        return getUserId().equals(that.getUserId()) && getTaskId().equals(that.getTaskId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getTaskId());
    }
}
