package com.sancrisxa.helpdesk.services;

import com.sancrisxa.helpdesk.models.Role;
import com.sancrisxa.helpdesk.models.User;
import com.sancrisxa.helpdesk.repositories.RolesRepository;
import com.sancrisxa.helpdesk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository repository, RolesRepository rolesRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.rolesRepository = rolesRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User create(User user) {

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = this.rolesRepository.findByName("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return this.repository.save(user);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<User> user = this.findById(id);
        if (user != null) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(Long id, User user) {
        Optional<User> userExists = findById(id);

        if (userExists != null) {

            userExists.get().setEmail(user.getEmail());
            userExists.get().setName(user.getName());
            userExists.get().setLastName(user.getLastName());
            userExists.get().setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
            userExists.get().setActive(user.getActive());

            User userUpdated = userExists.get();

            Role userRole = this.rolesRepository
                    .findByName(user.getRoles().iterator().next().getName());
            userExists.get().setRoles(new HashSet<>(Arrays.asList(userRole)));

            this.repository.save(userUpdated);

            return true;
        }
        return false;
    }

    @Override
    public Optional<User> show(Long id) {
        return findById(id);
    }

    @Override
    public List<User> findAllWhereRoleEquals(Long role_id, Long user_id) {
        return this.repository.findAllWhereRoleEquals(role_id, user_id);
    }

    @Override
    public User findCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String userName = auth.getName();

        User userLogged = this.repository.findByEmail(userName);

        return userLogged;
    }

    private Optional<User> findById(Long id) {

        return this.repository.findById(id);
    }
}
