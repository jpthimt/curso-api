package com.curso.api.curso;

import com.curso.api.entities.Curso;
import com.curso.api.services.CursoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CursoTeste {

    Curso curso = new Curso();

    @BeforeAll
    void iniciando(){
        System.out.println("Classe de teste CursoTeste iniciada");
    }

    @BeforeEach
    void antesDeCadaUm(){
        System.out.println("Testando um dos métodos...");
        curso = new Curso();
    }

    @AfterEach
    void depoisDeCadaUm(){
        System.out.println("Nome do curso: " + curso.getNome());
        curso = new Curso();
    }

    @AfterAll
    void terminando(){
        System.out.println("Chegamos ao final deste teste!");
    }


    @Test
    void testaSetaNome(){
        curso.setNome("Teste de nome do curso");
        assertNotNull(curso.getNome());
    }

    @Test
    void testaCursosNaoVazio() {
        Curso curso = new Curso();
        assertNotNull(curso);
    }

    @Test
    void valorDoCursoNaoNulo(){
        Curso curso = new Curso();
        assertNotNull(curso.getValorDoCurso());
    }

    @Test
    void testaNovoCursoValorZero(){
        Curso curso = new Curso();
        Assertions.assertEquals(new BigDecimal(0), curso.getValorDoCurso());
        Assertions.assertTrue(curso.getAlunos().isEmpty());
    }

    @Test
    void testaNovoCursoSemAlunos(){
        Curso curso = new Curso();
        Assertions.assertTrue(curso.getAlunos().isEmpty());
    }
}
