package com.sancrisxa.helpdesk.service;

import com.sancrisxa.helpdesk.models.Role;

import java.util.List;

public interface RolesService {
    public List<Role> findAll();
    public Role create(Role role);
    public Boolean delete(Long id);
    public Role findByName(String name);

}
