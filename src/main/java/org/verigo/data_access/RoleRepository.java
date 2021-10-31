package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
