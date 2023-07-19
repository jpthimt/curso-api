package com.curso.api.services;

import com.curso.api.entities.Curso;

import java.util.List;

public interface CursoService {

    public List<Curso> getCursos();

    public Curso save(Curso curso);
}
