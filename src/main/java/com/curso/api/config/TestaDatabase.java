package com.curso.api.config;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "test")
public class TestaDatabase implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public void run(String... args) throws Exception {
        Curso curso1 = new Curso("Tec. Inf.", "Exatas");
        Curso curso2 = new Curso("Prod. Pub.", "Humanas");
        Curso curso3 = new Curso("Com. Vis.", "Humanas");
        Curso curso4 = new Curso("Adm.", "Exatas");
        cursoRepository.save(curso1);
        cursoRepository.save(curso2);
        cursoRepository.save(curso3);
        cursoRepository.save(curso4);
    }
}
