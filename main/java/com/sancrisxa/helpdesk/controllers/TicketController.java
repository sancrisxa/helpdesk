package com.sancrisxa.helpdesk.controllers;

import com.sancrisxa.helpdesk.models.Role;
import com.sancrisxa.helpdesk.models.Ticket;
import com.sancrisxa.helpdesk.service.RolesService;
import com.sancrisxa.helpdesk.service.TicketService;
import com.sancrisxa.helpdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    private final Long ROLE_ID = Long.valueOf(4);

    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;
    @Autowired
    private RolesService rolesService;

    @GetMapping
    public String create(Model model) {
        model.addAttribute("ticket", new Ticket());
        Role adminRole = this.rolesService.findByName("ADMIN");
        model.addAttribute("techs", this.userService.findAllWhereRoleEquals(adminRole.getId()))
        //model.addAttribute("techs", this.userService.findAllWhereRoleEquals(ROLE_ID));
        return "ticket/create";
    }
}
