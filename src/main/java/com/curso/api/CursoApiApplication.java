package com.curso.api;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoApiApplication implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;
    public static void main(String[] args) {
        SpringApplication.run(CursoApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Curso curso1 = new Curso("Tec. Inf.", "Exatas");
        Curso curso2 = new Curso("Prod. Pub.", "Humanas");
        Curso curso3 = new Curso("Com. Vis.", "Humanas");
        Curso curso4 = new Curso("Adm.", "Exatas");
        Curso curso5 = new Curso("Geo.", "Humanas");
        cursoRepository.save(curso1);
        cursoRepository.save(curso2);
        cursoRepository.save(curso3);
        cursoRepository.save(curso4);
        cursoRepository.save(curso5);
    }
}
