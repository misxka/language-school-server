package org.verigo.data_access.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.verigo.data_access.RoleRepository;
import org.verigo.models.constraints.ROLES;
import org.verigo.models.Role;

@Component
public class RoleDataSeeder implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRoleData();
    }

    private void loadRoleData() {
        if(roleRepository.count() == 0) {
            Role admin = new Role(ROLES.ADMIN,"ADMIN");
            Role teacher = new Role(ROLES.TEACHER, "TEACHER");
            Role student = new Role(ROLES.STUDENT, "STUDENT");

            roleRepository.save(admin);
            roleRepository.save(teacher);
            roleRepository.save(student);
        }
    }
}