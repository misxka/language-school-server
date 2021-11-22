package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

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


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
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

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
