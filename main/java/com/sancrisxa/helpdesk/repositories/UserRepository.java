package com.sancrisxa.helpdesk.repositories;

import com.sancrisxa.helpdesk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select us.* from users us inner join users_roles ur on us.id = ur.user_id where ur.role_id = :role_id and us.id not in(:user_id)", nativeQuery = true)
    public List<User> findAllWhereRoleEquals(@Param("role_id") Long role_id, @Param("user_id") Long user_id);

    public User findByEmail(String email);
}
