package ru.itis.inf403.IO.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 50_000);

            InputStream is = socket.getInputStream();

            OutputStream os = socket.getOutputStream();

            os.write("Hello form client".getBytes(StandardCharsets.UTF_8));
            os.flush();

            byte[] buffer = new byte[100];

            int r = is.read(buffer);
            System.out.println(new String(buffer, 0, r));

            socket.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
