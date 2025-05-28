package ru.itis.inf403.IO.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerProtocol {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(50_000);

            //Ожидаем подключение клиента
            Socket clientSocket = serverSocket.accept();

            //Поток для чтения данных от клиента
            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
            //Поток для передачи данных клиенту
            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

            int size = is.readInt();
            byte[] buffer = new byte[size];
            is.read(buffer);
            System.out.println(new String(buffer));

            String message = "Hello, from serve";
            size = message.getBytes().length;

            os.writeInt(size);
            os.write(message.getBytes(StandardCharsets.UTF_8));
            os.flush();

            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
