package com.curso.api.repositories;

import com.curso.api.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    List<Curso> findByNomeContainingIgnoreCase(String nome);

}
