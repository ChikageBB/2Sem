package ru.itis.inf403.IO.net.DZ;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {


       try{

           Socket client = new Socket("localhost", 50000);

           BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));
           BufferedWriter os = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

           while (true){

               Scanner sc = new Scanner(System.in);
               String message = sc.nextLine();


               os.write(message);
               os.newLine();
               os.flush();

               if (message.equals("exit")){
                   break;
               }


               String serverMessage = is.readLine();

               System.out.println("Ответ сервера: " + serverMessage);


               if (serverMessage.equals("exit")){
                   break;
               }
           }

           is.close();
           os.close();
           client.close();

       }catch (IOException e){
           e.printStackTrace();
       }

    }
}
