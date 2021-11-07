package org.verigo.data_access.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.verigo.data_access.RolesRepository;
import org.verigo.models.constraints.ROLE;
import org.verigo.models.Role;

@Component
public class RoleDataSeeder implements CommandLineRunner {
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRoleData();
    }

    private void loadRoleData() {
        if(rolesRepository.count() == 0) {
            Role admin = new Role(ROLE.ADMIN,"ADMIN");
            Role teacher = new Role(ROLE.TEACHER, "TEACHER");
            Role student = new Role(ROLE.STUDENT, "STUDENT");

            rolesRepository.save(admin);
            rolesRepository.save(teacher);
            rolesRepository.save(student);
        }
    }
}