package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String title;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    @JsonBackReference
    private Course course;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks() {
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

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
