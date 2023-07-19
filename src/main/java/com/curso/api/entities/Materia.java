package com.curso.api.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(name = "grade_materia",
            joinColumns = {@JoinColumn(name = "materia_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "grade_id", referencedColumnName = "id")}
    )
    private Set<GradeCurricular> grades = new HashSet<>();

    public Materia() {
    }

    public Materia(String nome, Set<GradeCurricular> grades) {
        this.nome = nome;
        this.grades = grades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<GradeCurricular> getGrades() {
        return grades;
    }

    public void setGrades(Set<GradeCurricular> grades) {
        this.grades = grades;
    }
}
