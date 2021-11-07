package org.verigo.data_access.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.verigo.data_access.UsersRepository;
import org.verigo.models.Role;
import org.verigo.models.User;
import org.verigo.models.constraints.ROLE;

import java.util.Date;

@Component
public class UserDataSeeder implements CommandLineRunner {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRoleData();
    }

    private void loadRoleData() {
        if(usersRepository.count() == 0) {
            User user1 = new User();
            user1.setLogin("teacher1");
            user1.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user1.setSurname("Иванов");
            user1.setName("Иван");
            user1.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user1.setCreatedAt(new Date());
            user1.setUpdatedAt(new Date());

            usersRepository.save(user1);

            User user2 = new User();
            user2.setLogin("student1");
            user2.setPassword(BCrypt.hashpw("111qwerty", BCrypt.gensalt(12)));
            user2.setSurname("Петров");
            user2.setName("Пётр");
            user2.setRole(new Role(ROLE.STUDENT, "STUDENT"));
            user2.setCreatedAt(new Date());
            user2.setUpdatedAt(new Date());

            usersRepository.save(user2);

            User user3 = new User();
            user3.setLogin("admin123");
            user3.setPassword(BCrypt.hashpw("admin123", BCrypt.gensalt(12)));
            user3.setSurname("Admin");
            user3.setName("");
            user3.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user3.setCreatedAt(new Date());
            user3.setUpdatedAt(new Date());

            usersRepository.save(user3);

        }
    }
}
