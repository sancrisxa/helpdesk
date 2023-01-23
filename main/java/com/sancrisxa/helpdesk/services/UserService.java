package com.sancrisxa.helpdesk.services;

import com.sancrisxa.helpdesk.models.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();
    public User create(User user);
    public Boolean delete(Long id);
    public Boolean update(Long id, User user);
    public Optional<User> show(Long id);
    public List<User> findAllWhereRoleEquals(Long role_id, Long user_id);
    public User findCurrentUser();
}
