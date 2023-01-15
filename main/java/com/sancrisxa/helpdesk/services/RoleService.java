package com.sancrisxa.helpdesk.services;

import com.sancrisxa.helpdesk.models.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();
    public Role create(Role role);
    public Boolean delete(Long id);
    public Role findByName(String name);

}
