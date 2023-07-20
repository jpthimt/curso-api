package com.curso.api;

import com.curso.api.entities.Curso;
import com.curso.api.services.CursoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CursoApiApplicationTests {

    @Autowired
    private CursoService cursoService;

    @Test
    void contextLoads() {

        List<Curso> cursos = cursoService.getCursos();

        System.out.println("Cursos: ");
        System.out.println(cursos);
    }

}
