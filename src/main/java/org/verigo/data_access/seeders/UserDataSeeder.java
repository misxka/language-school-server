package org.verigo.data_access.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.verigo.data_access.UsersRepository;
import org.verigo.models.Role;
import org.verigo.models.User;
import org.verigo.models.constraints.ROLE;
import java.util.Calendar;
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

            User user01 = new User();
            user01.setLogin("teacher01");
            user01.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user01.setSurname("Иванов");
            user01.setName("Иван");
            user01.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user01.setCreatedAt(new Date());
            user01.setUpdatedAt(new Date());

            usersRepository.save(user01);

            User user02 = new User();
            user02.setLogin("teacher02");
            user02.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user02.setSurname("Иванов");
            user02.setName("Иван");
            user02.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user02.setCreatedAt(new Date());
            user02.setUpdatedAt(new Date());

            usersRepository.save(user02);

            User user03 = new User();
            user03.setLogin("teacher03");
            user03.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user03.setSurname("Иванов");
            user03.setName("Иван");
            user03.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user03.setCreatedAt(new Date());
            user03.setUpdatedAt(new Date());

            usersRepository.save(user03);

            User user04 = new User();
            user04.setLogin("teacher04");
            user04.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user04.setSurname("Иванов");
            user04.setName("Иван");
            user04.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user04.setCreatedAt(new Date());
            user04.setUpdatedAt(new Date());

            usersRepository.save(user04);

            User user05 = new User();
            user05.setLogin("teacher05");
            user05.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user05.setSurname("Иванов");
            user05.setName("Иван");
            user05.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user05.setCreatedAt(new Date());
            user05.setUpdatedAt(new Date());

            usersRepository.save(user05);

            User user06 = new User();
            user06.setLogin("teacher06");
            user06.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user06.setSurname("Иванов");
            user06.setName("Иван");
            user06.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user06.setCreatedAt(new Date());
            user06.setUpdatedAt(new Date());

            usersRepository.save(user06);

            User user07 = new User();
            user07.setLogin("student07");
            user07.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user07.setSurname("Иванов");
            user07.setName("Иван");
            user07.setRole(new Role(ROLE.STUDENT, "STUDENT"));
            user07.setCreatedAt(new Date());
            user07.setUpdatedAt(new Date());

            usersRepository.save(user07);

            User user08 = new User();
            user08.setLogin("student08");
            user08.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user08.setSurname("Круглов");
            user08.setName("Иван");
            user08.setRole(new Role(ROLE.STUDENT, "STUDENT"));
            user08.setCreatedAt(new Date());
            user08.setUpdatedAt(new Date());

            usersRepository.save(user08);

            User user09 = new User();
            user09.setLogin("student09");
            user09.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user09.setSurname("Лавров");
            user09.setName("Иван");
            user09.setRole(new Role(ROLE.STUDENT, "STUDENT"));
            user09.setCreatedAt(new Date());
            user09.setUpdatedAt(new Date());

            usersRepository.save(user09);

            User user010 = new User();
            user010.setLogin("teacher010");
            user010.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user010.setSurname("Иванов");
            user010.setName("Иван");
            user010.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user010.setCreatedAt(new Date());
            user010.setUpdatedAt(new Date());

            usersRepository.save(user010);

            User user011 = new User();
            user011.setLogin("teacher011");
            user011.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user011.setSurname("Иванов");
            user011.setName("Иван");
            user011.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user011.setCreatedAt(new Date());
            user011.setUpdatedAt(new Date());

            usersRepository.save(user011);

            User user012 = new User();
            user012.setLogin("teacher012");
            user012.setPassword(BCrypt.hashpw("12345678qwerty", BCrypt.gensalt(12)));
            user012.setSurname("Иванов");
            user012.setName("Иван");
            user012.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            user012.setCreatedAt(new Date());
            user012.setUpdatedAt(new Date());

            usersRepository.save(user012);


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

            User user4 = new User();
            user4.setLogin("admin1234");
            user4.setPassword(BCrypt.hashpw("admin123", BCrypt.gensalt(12)));
            user4.setSurname("Admin");
            user4.setName("");
            user4.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user4.setCreatedAt(new Date());
            user4.setUpdatedAt(new Date());

            usersRepository.save(user4);

            User user5 = new User();
            user5.setLogin("admin5");
            user5.setPassword(BCrypt.hashpw("admin123", BCrypt.gensalt(12)));
            user5.setSurname("Admin");
            user5.setName("");
            user5.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user5.setCreatedAt(new Date());
            user5.setUpdatedAt(new Date());

            usersRepository.save(user5);

            User user6 = new User();
            user6.setLogin("admin6");
            user6.setPassword(BCrypt.hashpw("admin1234", BCrypt.gensalt(12)));
            user6.setSurname("Admin");
            user6.setName("");
            user6.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user6.setCreatedAt(new Date());
            user6.setUpdatedAt(new Date());

            usersRepository.save(user6);

            User user7 = new User();
            user7.setLogin("admin7");
            user7.setPassword(BCrypt.hashpw("admin1234", BCrypt.gensalt(12)));
            user7.setSurname("Admin");
            user7.setName("");
            user7.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user7.setCreatedAt(new Date());
            user7.setUpdatedAt(new Date());

            usersRepository.save(user7);

            User user8 = new User();
            user8.setLogin("admin8");
            user8.setPassword(BCrypt.hashpw("admin1234", BCrypt.gensalt(12)));
            user8.setSurname("Admin");
            user8.setName("");
            user8.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user8.setCreatedAt(new Date());
            user8.setUpdatedAt(new Date());

            usersRepository.save(user8);

            User user9 = new User();
            user9.setLogin("admin9");
            user9.setPassword(BCrypt.hashpw("admin1234", BCrypt.gensalt(12)));
            user9.setSurname("Admin");
            user9.setName("");
            user9.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user9.setCreatedAt(new Date());
            user9.setUpdatedAt(new Date());

            usersRepository.save(user9);

            User user10 = new User();
            user10.setLogin("admin10");
            user10.setPassword(BCrypt.hashpw("admin1234", BCrypt.gensalt(12)));
            user10.setSurname("Admin");
            user10.setName("");
            user10.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user10.setCreatedAt(new Date());
            user10.setUpdatedAt(new Date());

            usersRepository.save(user10);

            User user11 = new User();
            user11.setLogin("admin11");
            user11.setPassword(BCrypt.hashpw("admin1234", BCrypt.gensalt(12)));
            user11.setSurname("Admin");
            user11.setName("");
            user11.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user11.setCreatedAt(new Date());
            user11.setUpdatedAt(new Date());

            usersRepository.save(user11);

            User user12 = new User();
            user12.setLogin("admin12");
            user12.setPassword(BCrypt.hashpw("admin1234", BCrypt.gensalt(12)));
            user12.setSurname("Admin");
            user12.setName("");
            user12.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            user12.setCreatedAt(new Date());
            user12.setUpdatedAt(new Date());

            usersRepository.save(user12);


            //previous years users
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 2020);

            User oldUser1 = new User();
            oldUser1.setLogin("oldAdmin1");
            oldUser1.setPassword(BCrypt.hashpw("oldAdmin1", BCrypt.gensalt(12)));
            oldUser1.setSurname("Сергеев");
            oldUser1.setName("Андрей");
            oldUser1.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            oldUser1.setCreatedAt(cal.getTime());
            oldUser1.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser1);

            User oldUser2 = new User();
            oldUser2.setLogin("oldAdmin2");
            oldUser2.setPassword(BCrypt.hashpw("oldAdmin2", BCrypt.gensalt(12)));
            oldUser2.setSurname("Сергеев");
            oldUser2.setName("Андрей");
            oldUser2.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            oldUser2.setCreatedAt(cal.getTime());
            oldUser2.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser2);

            User oldUser3 = new User();
            oldUser3.setLogin("oldStudent3");
            oldUser3.setPassword(BCrypt.hashpw("oldStudent3", BCrypt.gensalt(12)));
            oldUser3.setSurname("Сергеев");
            oldUser3.setName("Андрей");
            oldUser3.setRole(new Role(ROLE.STUDENT, "STUDENT"));
            oldUser3.setCreatedAt(cal.getTime());
            oldUser3.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser3);

            User oldUser4 = new User();
            oldUser4.setLogin("oldTeacher4");
            oldUser4.setPassword(BCrypt.hashpw("oldTeacher4", BCrypt.gensalt(12)));
            oldUser4.setSurname("Сергеев");
            oldUser4.setName("Андрей");
            oldUser4.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            oldUser4.setCreatedAt(cal.getTime());
            oldUser4.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser4);

            User oldUser5 = new User();
            oldUser5.setLogin("oldAdmin7");
            oldUser5.setPassword(BCrypt.hashpw("oldAdmin7", BCrypt.gensalt(12)));
            oldUser5.setSurname("Сергеев");
            oldUser5.setName("Андрей");
            oldUser5.setRole(new Role(ROLE.ADMIN, "ADMIN"));
            oldUser5.setCreatedAt(cal.getTime());
            oldUser5.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser5);

            User oldUser6 = new User();
            oldUser6.setLogin("oldTeacher1");
            oldUser6.setPassword(BCrypt.hashpw("oldTeacher1", BCrypt.gensalt(12)));
            oldUser6.setSurname("Сергеев");
            oldUser6.setName("Андрей");
            oldUser6.setRole(new Role(ROLE.TEACHER, "TEACHER"));
            cal.set(Calendar.YEAR, 2019);
            oldUser6.setCreatedAt(cal.getTime());
            oldUser6.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser6);

            User oldUser7 = new User();
            oldUser7.setLogin("oldStudent1");
            oldUser7.setPassword(BCrypt.hashpw("oldStudent1", BCrypt.gensalt(12)));
            oldUser7.setSurname("Сергеев");
            oldUser7.setName("Андрей");
            oldUser7.setRole(new Role(ROLE.STUDENT, "STUDENT"));
            cal.set(Calendar.YEAR, 2019);
            oldUser7.setCreatedAt(cal.getTime());
            oldUser7.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser7);

            User oldUser8 = new User();
            oldUser8.setLogin("oldStudent123");
            oldUser8.setPassword(BCrypt.hashpw("oldStudent123", BCrypt.gensalt(12)));
            oldUser8.setSurname("Сергеев");
            oldUser8.setName("Андрей");
            oldUser8.setRole(new Role(ROLE.STUDENT, "STUDENT"));
            cal.set(Calendar.YEAR, 2019);
            oldUser8.setCreatedAt(cal.getTime());
            oldUser8.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser8);

            User oldUser9 = new User();
            oldUser9.setLogin("oldStudent122");
            oldUser9.setPassword(BCrypt.hashpw("oldStudent122", BCrypt.gensalt(12)));
            oldUser9.setSurname("Сергеев");
            oldUser9.setName("Андрей");
            oldUser9.setRole(new Role(ROLE.STUDENT, "STUDENT"));
            cal.set(Calendar.YEAR, 2019);
            oldUser9.setCreatedAt(cal.getTime());
            oldUser9.setUpdatedAt(cal.getTime());

            usersRepository.save(oldUser9);
        }
    }
}


//TODO Probably add some seeders for other entities (especially, for tasks)
