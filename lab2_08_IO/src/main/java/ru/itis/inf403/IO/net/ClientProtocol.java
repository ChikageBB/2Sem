package ru.itis.inf403.IO.net;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientProtocol {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 50_000);

            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            String message = "Hello from client";
            //измеряем кол-во байт в сообщении
            int size = message.getBytes().length;

            os.writeInt(size); // заголовок пакета
            os.write(message.getBytes(StandardCharsets.UTF_8)); // тело пакета
            os.flush();

            size = is.readInt();
            byte[] buffer = new byte[size];
            int r = is.read(buffer);
            System.out.println(new String(buffer, 0, r));

            socket.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}