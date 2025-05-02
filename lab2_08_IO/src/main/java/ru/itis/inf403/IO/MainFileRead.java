package ru.itis.inf403.IO;

import java.io.*;

public class MainFileRead {
    public static void main(String[] args) {

        File f = new File("test1.txt");

        try (InputStream fis = new FileInputStream(f)) {
            byte[] buffer = new byte[1024];
            int r; // количество реально считанных байт
            long start = System.nanoTime();

            while ((r = fis.read(buffer)) > -1){
                System.out.print(new String(buffer, 0, r).toUpperCase());
            }

            long end = System.nanoTime();
            System.out.println("Считали за : " + (end - start));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
