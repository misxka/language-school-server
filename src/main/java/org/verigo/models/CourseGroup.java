package org.verigo.models;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "course_groups")
public class CourseGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    @JsonIgnoreProperties("groups")
    private Course course;

    @ManyToMany
    @JoinTable(
        name = "user_course_group",
        joinColumns = @JoinColumn(name = "course_group_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnoreProperties("groups")
    private Set<User> participants = new HashSet<>();

    public CourseGroup() {

    }

    public CourseGroup(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public void addParticipants(User user) {
        this.participants.add(user);
    }

    public void setName(String name) {
        this.name = name;
    }
}
