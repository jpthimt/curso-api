package com.curso.api.services.impl;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;
import com.curso.api.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso save(Curso curso) {
        curso.setId(null);
        return cursoRepository.save(curso);
    }

    @Override
    public Curso findById(Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }

    @Override
    public List<Curso> findByNome(String nome) {
        return cursoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public void update(Curso curso) {
        Curso atual = this.findById(curso.getId());
        atual.setNome(curso.getNome());
        atual.setArea(curso.getArea());
        cursoRepository.save(atual);
    }

    @Override
    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }

}
