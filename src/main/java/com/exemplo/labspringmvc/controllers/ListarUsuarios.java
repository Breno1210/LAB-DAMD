package com.exemplo.labspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListarUsuarios {
    @GetMapping("/listarusuarios")
    public String listarusuarios() {
        return "listarusuarios";
    }
}
