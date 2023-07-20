package com.curso.api.resources;

import com.curso.api.entities.Curso;
import com.curso.api.dto.CursoDTO;
import com.curso.api.mapper.CursoMapper;
import com.curso.api.services.CursoService;
import jakarta.validation.Valid;
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

    @Autowired
    private CursoMapper cursoMapper;

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos(){
        List<Curso> lista = cursoService.getCursos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findCurso(@PathVariable Integer id){
        Curso curso = cursoService.findById(id);
        return ResponseEntity.ok().body(curso);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Curso>> findCurso(@RequestParam String nome){
        List<Curso> cursos = cursoService.findByNome(nome);
        return ResponseEntity.ok().body(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> saveCurso(@Valid @RequestBody CursoDTO dto) throws URISyntaxException {
        Curso novoCurso = cursoService.save(cursoMapper.mapCursoDTOToCurso(dto));
        return ResponseEntity.created(new URI("/cursos/salva/" + novoCurso.getId())).body(novoCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@Valid @RequestBody CursoDTO dto, @PathVariable Integer id){
        Curso cursoNovo = cursoMapper.mapCursoDTOToCurso(dto);
        cursoNovo.setId(id);
        cursoService.update(cursoNovo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Integer id){
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
