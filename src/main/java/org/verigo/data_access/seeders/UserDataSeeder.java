package org.verigo.data_access.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.verigo.data_access.UserRepository;
import org.verigo.models.Role;
import org.verigo.models.User;
import org.verigo.models.constraints.ROLES;

@Component
public class UserDataSeeder implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRoleData();
    }

    private void loadRoleData() {
        if(userRepository.count() == 0) {
            User user1 = new User();
            user1.setLogin("teacher1");
            user1.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user1.setSurname("Иванов");
            user1.setName("Иван");
            user1.setRole(new Role(ROLES.TEACHER, "TEACHER"));

            userRepository.save(user1);

            User user2 = new User();
            user2.setLogin("student1");
            user2.setPassword(BCrypt.hashpw("111qwerty", BCrypt.gensalt(12)));
            user2.setSurname("Петров");
            user2.setName("Пётр");
            user2.setRole(new Role(ROLES.STUDENT, "STUDENT"));

            userRepository.save(user2);
        }
    }
}
