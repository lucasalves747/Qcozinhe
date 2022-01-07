package com.Jping.Qcozinhe.Refatorando;

public class ReplaceString {

    public static String replace(String frase) {
        String text = frase.replace("{", "");
        String text1 = text.replace("}", "");
        String text2 = text1.replace(":", "");
        String text3 = text2.replace("nome_receitas", " <br><br><br>-----------------------------------<br><br><h2>NOME DA RECEITA</h2>");
        String text4 = text3.replace("ingredientes", "<h2>INGREDIENTES</h2>");
        String text5 = text4.replace("modo_preparo", "<h2>MODO DE PREPARO</h2>");
        //String text6 = text5.replace("nome", "<h2>NOME</h2>");
        String text7 = text5.replace('"', '"');
        String text8 = text7.replace("_", " ");
        String text9 = text8.replace("[", "");
        String text10 = text9.replace("]", "");


        return text10;
    }
    public String spliting(String text){
        String texto = replace(text);
        int numeroOcorrncia = numeroOcorrencia(texto,'#','=');
        String[] texto1 = texto.split("nome img");
        String nomes_img = "";
        for(int i = 0;i <numeroOcorrncia;i++) {
            String[] texto2 = texto1[i].split("<br><br><br>-----------------------------------");
            nomes_img = nomes_img+texto2[i];
        }
        return nomes_img+" numero:"+numeroOcorrncia;

    }


    public Integer numeroOcorrencia(String s,Character  c,Character c2){
        int tamanho = s.length();
        Integer ocorrencias = 0;
        for(int i = 0 ;i<tamanho;i++){
            if(s.charAt(i) == c && s.charAt(i+1) == c2){
                ocorrencias++;
            }
        }
        return ocorrencias;
    }
}