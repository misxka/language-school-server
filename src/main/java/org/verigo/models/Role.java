package org.verigo.models;

import org.verigo.models.constraints.ROLES;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    private ROLES id;

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

    public Role(ROLES id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
        this.id = ROLES.STUDENT;
        this.name = "NOT_ASSIGNED";
        this.users = null;
    }
}
