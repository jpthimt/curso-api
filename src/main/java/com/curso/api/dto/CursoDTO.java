package com.curso.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class CursoDTO implements Serializable {


    private Integer id;

    @NotNull
    @NotEmpty(message = "O nome está vazio")
    @Size(max = 30)
    private String nome;

    @NotBlank
    private String area;

    public CursoDTO(){
    }

    public CursoDTO(Integer id, String nome, String area) {
        this.id = id;
        this.nome = nome;
        this.area = area;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
