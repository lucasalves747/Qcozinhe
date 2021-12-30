package com.Jping.Qcozinhe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FindId {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String  nome_receitas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_receitas() {
        return nome_receitas;
    }

    public void setNome_receitas(String nome_receitas) {
        this.nome_receitas = nome_receitas;
    }


}
