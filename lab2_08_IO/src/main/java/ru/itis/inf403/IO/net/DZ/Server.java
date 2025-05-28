package ru.itis.inf403.IO.net.DZ;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) {


       try (ServerSocket server = new ServerSocket(50_000);
                Socket client = server.accept()){


           System.out.println("Сервер запущен");

           BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

           BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

           Scanner scanner = new Scanner(System.in);

           while (true){
               String clientMessage = in.readLine();
               System.out.println("Сообщение от клиента: " + clientMessage);

               if (clientMessage.equals("exit")){
                   break;
               }

               String serverMessage = scanner.nextLine();

               out.write(serverMessage);
               out.newLine();
               out.flush();

               if (serverMessage.equals("exit")){
                   break;
               }

           }

       }catch (IOException e){

       }

    }
}
