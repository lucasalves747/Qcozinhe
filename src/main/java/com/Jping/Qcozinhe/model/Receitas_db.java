package com.Jping.Qcozinhe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Receitas_db {
    @Id
    private String nome_receitas;
    @Lob
    @Column(length=2147483647)
    private String ingredientes;
    @Lob
    @Column(length=2147483647)
    private String modo_preparo;
    @Column
    private String nome;

    public String getNome_receitas() {
        return nome_receitas;
    }

    public void setNome_receitas(String nome_receitas) {
        this.nome_receitas = nome_receitas;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModo_preparo() {
        return modo_preparo;
    }

    public void setModo_preparo(String modo_preparo) {
        this.modo_preparo = modo_preparo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
