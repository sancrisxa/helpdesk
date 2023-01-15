package com.sancrisxa.helpdesk.controllers;

import com.sancrisxa.helpdesk.models.Role;
import com.sancrisxa.helpdesk.models.Ticket;
import com.sancrisxa.helpdesk.service.RolesService;
import com.sancrisxa.helpdesk.service.TicketService;
import com.sancrisxa.helpdesk.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;
    @Autowired
    private RolesService rolesService;

    @GetMapping("{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ticket", this.ticketService.show(id));
        return "ticket/show";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", this.ticketService.findAll());
        return "ticket/index";
    }

    @GetMapping
    public String create(Model model) {
        model = this.ticketService.createTemplate(model);

        return "ticket/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "ticket/create";
        }

        this.ticketService.create(ticket);

        return "redirect:/tickets";
    }
}
