package com.sancrisxa.helpdesk.service;

import com.sancrisxa.helpdesk.models.Ticket;
import com.sancrisxa.helpdesk.models.User;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    public List<Ticket> findAll();
    public Model createTemplate(Model model);
    public Ticket create(Ticket ticket);
    public Boolean delete(Long id);
    public Boolean update(Long id, Ticket ticket);
    public Ticket show(Long id);
}
