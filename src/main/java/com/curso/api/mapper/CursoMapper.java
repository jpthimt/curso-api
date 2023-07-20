package com.curso.api.mapper;

import com.curso.api.entities.Curso;
import com.curso.api.dto.CursoDTO;
import org.springframework.stereotype.Service;

@Service
public class CursoMapper {

    public Curso mapCursoDTOToCurso(CursoDTO dto){
        Curso curso = new Curso(dto.getNome(), dto.getArea());
        return curso;
    }
}
