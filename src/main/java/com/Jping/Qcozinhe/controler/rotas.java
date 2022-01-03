package com.Jping.Qcozinhe.controler;

import com.Jping.Qcozinhe.model.Receitas_db;
import com.Jping.Qcozinhe.repository.Receita_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rotas {


    @Autowired
    Receita_repository repositorio;

    Receitas_db receita = new Receitas_db();


    @GetMapping(path = "/status")
    public String status(){
        return "online";
    }



    @GetMapping(path = "consulta/nome/{nome}")
    public ResponseEntity consulta_by_nome(@PathVariable("nome") String nome){

        return repositorio.findById(nome).map(record ->ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping(path = "consulta/tudo")
    public Iterable<Receitas_db> consulta_tudo(){
        return repositorio.findAll();
    }

    @GetMapping(path ="salvar/{nome_receita}/{ingredientes}/{modo_preparo}/{nome}")
    public Receitas_db salvar(@PathVariable("nome_receita") String nome_receita,@PathVariable("ingredientes") String ingredientes,@PathVariable("modo_preparo") String modo_preparo,@PathVariable("nome") String nome){

        receita.setNome_receitas(nome_receita);
        receita.setIngredientes(ingredientes);
        receita.setModo_preparo(modo_preparo);
        receita.setNome(nome);
        return repositorio.save(receita);
    }



}
