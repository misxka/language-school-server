package org.verigo.data_access;

import org.verigo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
    User findById(int id);
    List<User> findAll();
}
