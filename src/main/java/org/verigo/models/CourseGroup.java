package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "course_groups")
public class CourseGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    private Course course;

    @ManyToMany
    @JoinTable(
        name = "user_course_group",
        joinColumns = @JoinColumn(name = "course_group_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> participants;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATETIME(0)")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "DATETIME(0)")
    private Date updatedAt;


    @JsonCreator
    public CourseGroup(
            @JsonProperty("course") Course course,
            @JsonProperty("participants") Set<User> participants,
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("updatedAt") Date updatedAt
    ) {
        this.course = course;
        this.participants = participants;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @JsonCreator
    public CourseGroup() {

    }


    public CourseGroup update(CourseGroup courseGroup) {
        this.course = courseGroup.course;
        this.participants = courseGroup.participants;
        this.createdAt = courseGroup.createdAt;
        this.updatedAt = courseGroup.updatedAt;

        return this;
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


    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }
}
