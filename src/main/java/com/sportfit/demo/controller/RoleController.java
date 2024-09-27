package com.sportfit.demo.controller;

import com.sportfit.demo.model.Role;
import com.sportfit.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String listRoles(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "role/list";
    }

    @GetMapping("/new")
    public String newRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "role/new";
    }

    @PostMapping
    public String saveRole(@ModelAttribute Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }


    @PostMapping("/{id}")
    public String updateRole(@PathVariable Long id, @ModelAttribute Role role) {
        role.setId(id);
        roleService.save(role);
        return "redirect:/roles";
    }

    @PostMapping("/{id}/delete")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
        return "redirect:/roles";
    }
}
