package com.sancrisxa.helpdesk.controllers;

import com.sancrisxa.helpdesk.models.Role;
import com.sancrisxa.helpdesk.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService rolesService;

    public RoleController(RoleService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", this.rolesService.findAll());
        return "/roles/index";
    }

    @GetMapping("/new")
    public String create(Model model) {

        model.addAttribute("role", new Role());
        return "/roles/create";
    }


    @PostMapping
    public String save(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "redirect:/roles/new";
        }

        Role roleCreated = this.rolesService.create(role);

        return "redirect:/roles";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id, Model model) {

        this.rolesService.delete(id);

        return "redirect:/roles";
    }
}
