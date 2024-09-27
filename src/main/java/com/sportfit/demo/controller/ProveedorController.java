package com.sportfit.demo.controller;

import com.sportfit.demo.model.Proveedor;
import com.sportfit.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String listProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.findAll();
        model.addAttribute("proveedores", proveedores);
        return "proveedor/list";
    }

    @GetMapping("/new")
    public String newProveedorForm(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/new";
    }

    @PostMapping
    public String saveProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/{id}/edit")
    public String editProveedorForm(@PathVariable Long id, Model model) {
        Proveedor proveedor = proveedorService.findById(id);
        model.addAttribute("proveedor", proveedor);
        return "proveedor/edit";
    }

    @PostMapping("/{id}")
    public String updateProveedor(@PathVariable Long id, @ModelAttribute Proveedor proveedor) {
        proveedor.setId(id);
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    @PostMapping("/{id}/delete")
    public String deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteById(id);
        return "redirect:/proveedores";
    }
}
