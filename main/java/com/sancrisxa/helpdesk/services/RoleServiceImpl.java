package com.sancrisxa.helpdesk.services;

import com.sancrisxa.helpdesk.models.Role;
import com.sancrisxa.helpdesk.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesRepository repository;

    public RoleServiceImpl(RolesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Role create(Role role) {
        role.setName(role.getName().toUpperCase());
        Role roleCreated = this.repository.save(role);
        return roleCreated;
    }

    @Override
    public Boolean delete(Long id) {
        if (this.findById(id) != null) {
            this.repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Role findByName(String name) {
        return this.repository.findByName(name);
    }

    private Optional<Role> findById(Long id) {
        return this.repository.findById(id);
    }
}
