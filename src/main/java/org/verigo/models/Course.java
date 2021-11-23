package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private BigDecimal price;

    @Column(name = "is_online", columnDefinition = "TINYINT(1)")
    private boolean isOnline;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Lesson> lessons;

//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<CourseGroup> groups;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

//    public Set<CourseGroup> getGroups() {
//        return groups;
//    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

//    public void setGroups(Set<CourseGroup> groups) {
//        this.groups = groups;
//    }
}
