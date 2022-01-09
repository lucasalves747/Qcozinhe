package com.Jping.Qcozinhe.controler;


import com.Jping.Qcozinhe.model.Receitas_db;
import com.Jping.Qcozinhe.repository.Receita_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public Iterable<Receitas_db> consulta_cru(){
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
    public String consulta_img(@PathVariable("nome_img") String nome_img){
        Path caminho = Paths.get(nome_img);
        String html = null;
        try {
            byte[] texto = Files.readAllBytes(caminho);
            String leitura = new String(texto);
            html =" <!DOCTYPE html> <html lang='pt-br'> <head><meta charset='UTF-8'><title>adicionado</title></head><body><img src='data:image/jpeg;base64,"+leitura+"'></body></html>";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;

    }

    @GetMapping(path = "/split/{numero}/{text}")
    public String SplitNumeImage(@PathVariable("numero") Integer numero,@PathVariable("text") String text){

        String[] Nome_text = text.split("#=");
        String aux = Nome_text[numero];
        return aux;
    }
    @GetMapping(path = "/temanhoArray/{text}")
    public Integer tamanho_arry(@PathVariable("text") String text){
        String[] aux = text.split("#=");
        return aux.length;
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
