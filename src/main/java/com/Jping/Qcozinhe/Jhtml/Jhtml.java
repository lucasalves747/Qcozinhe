package com.Jping.Qcozinhe.Jhtml;

import com.Jping.Qcozinhe.Refatorando.ReplaceString;
import com.Jping.Qcozinhe.request.Requisiçao;

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
}
