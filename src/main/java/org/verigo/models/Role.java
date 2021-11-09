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
        switch(this.id) {
            case ADMIN:
                this.name = "ADMIN";
                break;
            case TEACHER:
                this.name = "TEACHER";
                break;
            case STUDENT:
                this.name = "STUDENT";
                break;
        }
        this.users = null;
    }

    public String getName() {
        return name;
    }

    public ROLE getId() {
        return id;
    }
}
