package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
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


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Task> getTasks() {
        return tasks;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
