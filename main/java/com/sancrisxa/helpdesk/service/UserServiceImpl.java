package com.sancrisxa.helpdesk.service;

import com.sancrisxa.helpdesk.models.User;
import com.sancrisxa.helpdesk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User create(User user) {
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
        return null;
    }

    private Optional<User> findById(Long id) {
        return this.repository.findById(id);
    }
}
