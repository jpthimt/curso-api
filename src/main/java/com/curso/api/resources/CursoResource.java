package com.curso.api.resources;

import com.curso.api.entities.Curso;
import com.curso.api.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos(){
        List<Curso> lista = cursoService.getCursos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping("/salva")
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso) throws URISyntaxException {
        Curso novoCurso = cursoService.save(curso);
        return ResponseEntity.created(new URI("/cursos/salva/" + novoCurso.getId())).body(novoCurso);
    }
}
