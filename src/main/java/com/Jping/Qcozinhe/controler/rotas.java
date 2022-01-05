package com.Jping.Qcozinhe.controler;

import com.Jping.Qcozinhe.model.Receitas_db;
import com.Jping.Qcozinhe.repository.Receita_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

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

    @PostMapping(path ="salvar")
    public Receitas_db salvar(@RequestParam("nome_receita") String nome_receita, @RequestParam("ingredientes") String ingredientes, @RequestParam("modo_preparo") String modo_preparo, @RequestParam("nome") String nome , @RequestParam("img") String img, @RequestParam("nome_img") String nome_img){

        receita.setNome_receitas(nome_receita);
        receita.setIngredientes(ingredientes);
        receita.setModo_preparo(modo_preparo);
        receita.setNome(nome);
        receita.setNome_img(nome_img);
        save_encoda(nome_img,img);

        return repositorio.save(receita);
    }

    @GetMapping(path = "consulta/img/{nome_img}")
    public byte[] consulta_img(@PathVariable("nome_img") String nome_img) throws IOException {
        FileInputStream inputStream = new FileInputStream(nome_img);

        byte[] data = Base64.getDecoder().decode(new String(inputStream.readAllBytes()));
        return data;
    }

    @GetMapping(path = "/paginaADD")
    public String pagina_adicionar(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>adicionado</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"https://qcozinhe.herokuapp.com/salvar\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "    <label>selecione a foto:</label>\n" +
                "    <input type=\"file\" name=\"img\" accept=\".jpg,.gif,.png\">\n" +
                "    <label>nome da receita:</label>\n" +
                "    <input type=\"text\" name=\"nome_receita\">\n" +
                "    <label>ingredientes:</label>\n" +
                "    <input type=\"text\" name=\"ingredientes\">\n" +
                "    <label>modo de preparo</label>\n" +
                "    <input type=\"text\" name=\"modo_preparo\">\n" +
                "    <label>seu nome</label>\n" +
                "    <input type=\"text\" name=\"nome\">\n" +
                "    <input type=\"submit\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }

    public static void save_encoda(String nome_img,String img){
        FileWriter fileWriter= null;
        try {

            fileWriter = new FileWriter(nome_img);
            fileWriter.write(img);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
