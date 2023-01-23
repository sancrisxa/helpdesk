package com.sancrisxa.helpdesk.controllers;

import com.sancrisxa.helpdesk.models.Interaction;
import com.sancrisxa.helpdesk.services.InteractionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tickets/{ticketId}/interactions")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping
    public String save(@PathVariable("ticketId") Long ticketId, @Valid @ModelAttribute("interaction")Interaction interaction, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "ticket/show";
        }

        this.interactionService.create(interaction, ticketId);
        return "redirect:/ticket/" + ticketId;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("ticketId") Long ticketId, @PathVariable("id") Long id, Model model) {

        this.interactionService.delete(id, ticketId);
        return "redirect:/tickets/" + ticketId;
    }
}
