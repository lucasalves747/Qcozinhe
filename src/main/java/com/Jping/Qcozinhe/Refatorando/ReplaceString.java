package com.Jping.Qcozinhe.Refatorando;

public class ReplaceString {

    public String replace(String frase){
        String text = frase.replace("{","");
        String text1 = text.replace("}","");
        String text2 = text1.replace(":","");
        String text3 = text2.replace("nome_receitas","<br><br><br>-----------------------------------<br><br><h1>NOME DA RECEITA</h1>");
        String text4 = text3.replace("ingredientes","<h1>INGREDIENTES</h1>");
        String text5 = text4.replace("modo_preparo","<h1>MODO DE PREPARO</h1>");
        String text6 = text5.replace("nome","<h1>NOME</h1>");
        String text7 = text6.replace('"','"');
        String text8 = text7.replace("_"," ");
        String text9 = text8.replace("[","");
        String text10 = text9.replace("]","");



        return text7;
    }
}
