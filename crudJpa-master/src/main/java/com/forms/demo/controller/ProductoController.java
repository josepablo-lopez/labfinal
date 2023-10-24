package com.forms.demo.controller;

import com.forms.demo.modelo.Producto;
import com.forms.demo.serviceInterface.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping({"/","/listar"})
    public String listar(Model model) {
        model.addAttribute("productos", service.listar());
        return "index.html";
    }
    @GetMapping("/listar/{id}")
    public String listarId(@PathVariable int id, Model model) {
        model.addAttribute("producto", service.listarId(id));
        return "form.html";
    }

    @GetMapping("/new")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "form.html";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("producto", service.listarId(id));
        return "form.html";
    }
    @PostMapping("/save")
    public String save(Producto p, Model model) {
        int id = service.save(p);
        if (id == 0) {
            return "form.html";
        }
        return "redirect:/listar";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        service.delete(id);
        return "redirect:/listar";
    }

}
