package org.verigo.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String title;

    private BigDecimal price;

    private String language;

    private String level;

    @Column(name = "is_online", columnDefinition = "TINYINT(1)")
    private boolean isOnline;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("course")
    private List<CourseGroup> groups;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @JsonProperty(value = "isOnline")
    public boolean isOnline() {
        return isOnline;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public List<CourseGroup> getGroups() {
        return groups;
    }

    public String getLanguage() {
        return language;
    }

    public String getLevel() {
        return level;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setGroups(List<CourseGroup> groups) {
        this.groups = groups;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
