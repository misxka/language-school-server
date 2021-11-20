package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.verigo.models.user_task.UserTask;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean isHometask;

    @Column(name = "max_points")
    private int maxPoints;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATETIME(0)")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "DATETIME(0)")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="lesson_id", nullable = false)
    private Lesson lesson;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private Set<UserTask> userPoints;


    @JsonCreator
    public Task(
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("isHometask") boolean isHometask,
            @JsonProperty("maxPoints") int maxPoints,
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("updatedAt") Date updatedAt,
            @JsonProperty("lesson") Lesson lesson,
            @JsonProperty("userPoints") Set<UserTask> userPoints) {
        this.lesson = lesson;
        this.title = title;
        this.description = description;
        this.isHometask = isHometask;
        this.maxPoints = maxPoints;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userPoints = userPoints;
    }

    @JsonCreator
    public Task() {

    }


    public Task update(Task task) {
        this.lesson = task.lesson;
        this.title = task.title;
        this.description = task.description;
        this.isHometask = task.isHometask;
        this.maxPoints = task.maxPoints;
        this.createdAt = task.createdAt;
        this.updatedAt = task.updatedAt;
        this.userPoints = task.userPoints;

        return this;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public boolean isHometask() {
        return isHometask;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Set<UserTask> getUserPoints() {
        return userPoints;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHometask(boolean hometask) {
        isHometask = hometask;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setUserPoints(Set<UserTask> userPoints) {
        this.userPoints = userPoints;
    }
}
