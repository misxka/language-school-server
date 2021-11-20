package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Task> tasks;

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    @JsonBackReference
    private Course course;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATETIME(0)")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "DATETIME(0)")
    private Date updatedAt;


    @JsonCreator
    public Lesson(
            @JsonProperty("title") String title,
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("updatedAt") Date updatedAt,
            @JsonProperty("tasks") Set<Task> tasks,
            @JsonProperty("course") Course course) {
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.tasks = tasks;
        this.course = course;
    }

    @JsonCreator
    public Lesson() {

    }


    public Lesson update(Lesson lesson) {
        this.title = lesson.title;
        this.createdAt = lesson.createdAt;
        this.updatedAt = lesson.updatedAt;
        this.tasks = lesson.tasks;
        this.course = lesson.course;

        return this;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Course getCourse() {
        return course;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
