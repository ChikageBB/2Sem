package ru.itis.inf403.IO.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(50_000);

            //Ожидаем подключение клиента
            Socket clientSocket = serverSocket.accept();

            //Поток для чтения данных от клиента
            InputStream is = clientSocket.getInputStream();
            //Поток для передачи данных клиенту
            OutputStream os = clientSocket.getOutputStream();

            byte[] buffer = new byte[100];
            //читаем послание от клиента

            int r = is.read(buffer);
            System.out.println(new String(buffer, 0, r));

            //Отправляем клиенту
            os.write("Hello from server".getBytes(StandardCharsets.UTF_8));
            os.flush();

            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
