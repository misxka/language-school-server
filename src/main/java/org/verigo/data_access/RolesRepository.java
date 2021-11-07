package org.verigo.data_access;

import org.springframework.data.repository.CrudRepository;
import org.verigo.models.Role;

public interface RolesRepository extends CrudRepository<Role, Integer> {

}
