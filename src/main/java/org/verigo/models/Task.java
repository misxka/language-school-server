package org.verigo.models;

import com.fasterxml.jackson.annotation.*;
import org.verigo.models.user_task_result.UserTaskResult;

import javax.persistence.*;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="lesson_id")
    @JsonBackReference
    private Lesson lesson;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("task")
    private Set<UserTaskResult> usersResults;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @JsonProperty(value = "isHometask")
    public boolean isHometask() {
        return isHometask;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Set<UserTaskResult> getUsersResults() {
        return usersResults;
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

    public void setIsHometask(boolean isHometask) {
        this.isHometask = isHometask;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setUsersResults(Set<UserTaskResult> usersResults) {
        this.usersResults = usersResults;
    }
}
