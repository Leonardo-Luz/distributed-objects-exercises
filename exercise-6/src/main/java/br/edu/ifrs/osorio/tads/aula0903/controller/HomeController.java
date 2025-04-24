package br.edu.ifrs.osorio.tads.aula0903.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "HELLO WORLD!";
    }

    @GetMapping("/estudante")
    public String estudante(){
        return "Hello estudante!";
    }

    @GetMapping("/professor")
    public String professor(){
        return "Hello professor!";
    }

    @GetMapping("/administrador")
    public String administrador(){
        return "Hello administrador!";
    }

    @GetMapping("/visitante")
    public String visitante(){
        return "Hello visitante!";
    }
}
