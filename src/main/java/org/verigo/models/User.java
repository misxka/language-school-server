package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.verigo.models.user_task.UserTask;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String login;

    @JsonIgnore
    private String password;

    private String surname;

    private String name;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATETIME(0)")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "DATETIME(0)")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToMany(mappedBy = "participants")
    private Set<CourseGroup> groups;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserTask> taskPoints;


    @JsonCreator
    public User(
            @JsonProperty("login") String login,
            @JsonProperty("surname") String surname,
            @JsonProperty("name") String name,
            @JsonProperty("password") String password,
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("updatedAt") Date updatedAt,
            @JsonProperty("role") Role role,
            @JsonProperty("groups") Set<CourseGroup> groups,
            @JsonProperty("taskPoints") Set<UserTask> userTasks
    ) {
        this.login = login;
        this.surname = surname;
        this.name = name;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
        this.groups = groups;
        this.taskPoints = userTasks;
    }

    @JsonCreator
    public User() {

    }

    public User update(User user) {
        this.login = user.login;
        this.surname = user.surname;
        this.name = user.name;
        this.password = user.password;
        this.createdAt = user.createdAt;
        this.updatedAt = user.updatedAt;
        this.role = user.role;
        this.groups = user.groups;
        this.taskPoints = user.taskPoints;

        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<CourseGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<CourseGroup> groups) {
        this.groups = groups;
    }

    public Set<UserTask> getTaskPoints() {
        return taskPoints;
    }

    public void setTaskPoints(Set<UserTask> tasks) {
        this.taskPoints = tasks;
    }
}
