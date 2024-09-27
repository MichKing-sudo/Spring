package com.sportfit.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    @GetMapping("/index")
    public String login() {
        return "index"; // Nombre de la vista de login
    }

    @PostMapping("/index")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        // Aquí deberías validar el usuario con tus datos de usuarios
        if ("admin@example.com".equals(email)) {
            return "redirect:/home"; // Redirige a la página principal
        }
        model.addAttribute("error", "Credenciales inválidas");
        return "index"; // Si las credenciales son incorrectas, vuelve a mostrar el formulario
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Nombre de la vista de la página principal
    }
}
