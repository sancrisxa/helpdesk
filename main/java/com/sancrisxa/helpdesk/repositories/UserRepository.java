package com.sancrisxa.helpdesk.repositories;

import com.sancrisxa.helpdesk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
