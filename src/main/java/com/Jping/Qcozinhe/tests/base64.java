package com.Jping.Qcozinhe.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Base64;

public class base64 {
    public static void main(String[] args) throws Exception {
       System.out.print(encodeImage("C:\\Users\\MICRO\\Documents\\Jogador2.png","img_code.txt"));
        decodeImage("img_code.txt","C:\\users\\MICRO\\Documents\\imagens_encode\\img.png");
    }

    public static String encodeImage(String imgPath, String savePath )throws Exception{
        FileInputStream imgStream = new FileInputStream(imgPath);
        byte[] data =imgStream.readAllBytes();
        String imageString = Base64.getEncoder().encodeToString(data);

        FileWriter fileWriter= new FileWriter(savePath);

        fileWriter.write(imageString);

        fileWriter.close();
        imgStream.close();

        return imageString;
    }

    private static void decodeImage(String textPath,String savePath)throws Exception {
        FileInputStream inputStream = new FileInputStream(textPath);

        byte[] data = Base64.getDecoder().decode(new String(inputStream.readAllBytes()));
        //Base64.getDecoder().decode(inputStream.readAllBytes());

        FileOutputStream fileOutputStream = new FileOutputStream(savePath);
        fileOutputStream.write(data);
        fileOutputStream.close();
        inputStream.close();
    }
}
