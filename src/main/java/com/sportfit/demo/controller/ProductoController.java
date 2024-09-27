package com.sportfit.demo.controller;

import com.sportfit.demo.model.Producto;
import com.sportfit.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listProductos(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto/list"; // Vista de la lista de productos
    }

    @GetMapping("/new")
    public String newProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/new"; // Vista para crear un nuevo producto
    }

    @PostMapping
    public String saveProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/productos"; // Redirige a la lista de productos
    }

    @GetMapping("/{id}/edit")
    public String editProductoForm(@PathVariable Long id, Model model) {
        Producto producto = productoService.findById(id);
        model.addAttribute("producto", producto);
        return "producto/edit"; // Vista para editar un producto
    }

    @PostMapping("/{id}")
    public String updateProducto(@PathVariable Long id, @ModelAttribute Producto producto) {
        producto.setId(id);
        productoService.save(producto);
        return "redirect:/productos"; // Redirige a la lista de productos
    }

    @PostMapping("/{id}/delete")
    public String deleteProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return "redirect:/productos"; // Redirige a la lista de productos
    }
}
