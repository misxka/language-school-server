package org.verigo.models;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.verigo.models.user_task_result.UserTaskResult;

import javax.persistence.*;
import java.util.*;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String login;

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
    @JsonIgnoreProperties("participants")
    private List<CourseGroup> groups = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-results")
    private List<UserTaskResult> tasksResults = new ArrayList<>();


    public User update(User user) {
        this.login = user.login;
        this.surname = user.surname;
        this.name = user.name;
        this.password = user.password;
        this.createdAt = user.createdAt;
        this.updatedAt = user.updatedAt;
        this.role = user.role;

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

    public List<CourseGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<CourseGroup> groups) {
        this.groups = groups;
    }

    public List<UserTaskResult> getTasksResults() {
        return tasksResults;
    }

    public void setTasksResults(List<UserTaskResult> tasksResults) {
        this.tasksResults = tasksResults;
    }
}
