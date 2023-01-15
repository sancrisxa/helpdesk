package com.sancrisxa.helpdesk.services;

import com.sancrisxa.helpdesk.models.Ticket;
import org.springframework.ui.Model;

import java.util.List;

public interface TicketService {
    public List<Ticket> findAll();
    public Model findAllTechinician(Model model);
    public Ticket create(Ticket ticket);
    public Boolean delete(Long id);
    public Boolean update(Long id, Ticket ticket);
    public Ticket show(Long id);
    public List<Ticket> reportTicketByDays(Integer day);
}
