package com.sancrisxa.helpdesk.service;

import com.sancrisxa.helpdesk.models.Ticket;
import com.sancrisxa.helpdesk.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public User create(Ticket ticket) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Boolean update(Long id, Ticket ticket) {
        return null;
    }

    @Override
    public Optional<User> show(Long id) {
        return Optional.empty();
    }
}
