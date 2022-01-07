package com.Jping.Qcozinhe.Refatorando;

public class ReplaceString {

    public  String replace(String frase) {
        String text = frase.replace("{", "");
        String text1 = text.replace("}", "");
        String text2 = text1.replace(":", "");
        String text3 = text2.replace("nome_receitas", "#=  <br><br><br>-----------------------------------<br><br><h2>NOME DA RECEITA</h2>");
        String text4 = text3.replace("ingredientes", "<h2>INGREDIENTES</h2>");
        String text5 = text4.replace("modo_preparo", "<h2>MODO DE PREPARO</h2>");
        //String text6 = text5.replace("nome", "<h2>NOME</h2>");
        String text7 = text5.replace('"', '"');
        String text8 = text7.replace("_", " ");
        String text9 = text8.replace("[", "");
        String text10 = text9.replace("]", "");
        String text11 = text10.replace("nome img", "#=");


        return text11;
    }
    public String nomeImage(String text){
        String texto = replace(text);
        String[] texto1 = texto.split("#=");
        String nomeImage="";
        int numero = 0;
        for(int i = 0; i < texto.length();i++){
            if(texto.charAt(i)== '#' && texto.charAt(i+1) == '='){
                numero = numero+1;
            }
        }

        numero = numero/2;
        for(int i = 0;i<numero;i++){
            if((i%2) != 0){
                nomeImage =nomeImage+" "+texto1[i];
            }
        }


        return nomeImage;

    }

}