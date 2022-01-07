package com.Jping.Qcozinhe.Jhtml;

import com.Jping.Qcozinhe.Refatorando.ReplaceString;
import com.Jping.Qcozinhe.request.Requisiçao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Jhtml {
    public String html(){
        Requisiçao requisiçao = new Requisiçao();
        ReplaceString replaceString = new ReplaceString();

        String text = requisiçao.request();
        String Html = replaceString.replace(text);

        String nomeImages = replaceString.nomeImage(text);
        return "<!DOCTYPE html>\n" +
                "<html lang='pt-br'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <title>home</title>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +Html+ " <br><br>"+nomeImages+"</body>\n" +
                "</html>";
    }
    public static String replaceNomeImg(String tagHtml,String nome){

        String[] nome_img = nome.split(",");
        Path caminho = Paths.get(nome_img[0]);
        String html = null;
        try {
            byte[] texto = Files.readAllBytes(caminho);
            String leitura = new String(texto);
            tagHtml.replace("#=","<img src='data:image/jpeg;base64,"+leitura+"'>");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

