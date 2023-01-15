package com.sancrisxa.helpdesk.service;

import com.sancrisxa.helpdesk.models.Ticket;
import com.sancrisxa.helpdesk.models.User;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    public List<Ticket> findAll();
    public User create(Ticket ticket);
    public Boolean delete(Long id);
    public Boolean update(Long id, Ticket ticket);
    public Optional<User> show(Long id);
}
