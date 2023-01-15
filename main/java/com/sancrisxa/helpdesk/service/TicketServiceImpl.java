package com.sancrisxa.helpdesk.service;

import com.sancrisxa.helpdesk.models.Role;
import com.sancrisxa.helpdesk.models.Ticket;
import com.sancrisxa.helpdesk.models.User;
import com.sancrisxa.helpdesk.repositories.TicketRepository;
import com.sancrisxa.helpdesk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    private final Long ROLE_ID = Long.valueOf(4);
    private final String ROLE_NAME = "ADMIN";
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RolesService rolesService;

    @Autowired
    UserService userService;

    public TicketServiceImpl(
            TicketRepository ticketRepository,
            UserRepository userRepository,
            RolesService rolesService,
            UserService userService
    ) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.rolesService = rolesService;
        this.userService = userService;
    }

    @Override
    public List<Ticket> findAll() {
        return (List<Ticket>) this.ticketRepository.findAll();
    }

    @Override
    public Model createTemplate(Model model) {

        model.addAttribute("ticket", new Ticket());
        Role adminRole = this.rolesService.findByName(ROLE_NAME);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();

        User userLogged = this.userRepository.findByEmail(userName);

        model.addAttribute("techs", this.userService.findAllWhereRoleEquals(adminRole.getId(), userLogged.getId()));
        return model;
    }

    @Override
    public Ticket create(Ticket ticket) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User userLogged = this.userRepository.findByEmail(userName);
        ticket.setUserOpen(userLogged);
        return this.ticketRepository.save(ticket);
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
    public Ticket show(Long id) {

        return this.ticketRepository.findOne(id);
    }
}
