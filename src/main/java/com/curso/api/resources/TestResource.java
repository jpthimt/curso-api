package com.curso.api.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestResource {

    @GetMapping("/oi")
    public String getOi(){
        return "Oi Pessoal!";
    }
    @GetMapping("/ola")
    public String getOla(){
        return "Olá Pessoal!";
    }
}
