package ru.itis.inf403.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainCopy {

    private String inputFile;
    private String outputFile;


    public static void main(String[] args) {
        MainCopy mc = new MainCopy();
        mc.input();
        mc.copy();

    }

    private void input(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите имя файла ");
        inputFile = sc.nextLine();

        System.out.println("Введите имя копии ");
        outputFile = sc.nextLine();

        File check = new File(inputFile);
        if (!(check.isFile() && check.exists())){
            throw new RuntimeException("Файла не существует");
        }

    }
    private void copy(){
        try(InputStream fis = new FileInputStream(inputFile);
            OutputStream fos = new FileOutputStream(outputFile)){

            byte[] buffer = new byte[1024];
            int r;

            while ((r = fis.read(buffer)) > -1){
                //fos.write(buffer, 0, r);
                fos.write(new String(buffer, 0, r).toUpperCase().getBytes(StandardCharsets.UTF_8));
            }
            fos.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

