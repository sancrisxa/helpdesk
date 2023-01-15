package com.sancrisxa.helpdesk.repositories;

import com.sancrisxa.helpdesk.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
