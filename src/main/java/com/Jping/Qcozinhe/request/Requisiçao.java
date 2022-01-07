package com.Jping.Qcozinhe.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requisiçao {

    public String request(){
        String resposta="";
        try {
            URL url =  new URL("http://qcozinhe.herokuapp.com/dadosCru/tudo");
            HttpURLConnection connection =(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            String line = "";
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null ){
                response.append(line);
            }
            bufferedReader.close();
            resposta = response.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return  resposta;
    }
}
