package org.verigo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.verigo.models.constraints.ROLE;

import javax.persistence.*;
import java.util.List;

@Entity(name = "roles")
public class Role {
    @Id
    private ROLE id;

    @JsonIgnore
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

    public Role(ROLE id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
        this.id = ROLE.STUDENT;
        this.name = "NOT_ASSIGNED";
        this.users = null;
    }

    public String getName() {
        return name;
    }

    public ROLE getId() {
        return id;
    }
}
