package ru.itis.inf403.IO.net;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Общение в рамках договоренности о формате сообщейний (протокол)
 * |длина сообщения (4 байта)|сообщение заявленной длины|
 */
public class ClientMessage {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 50000);
            // Поток для чтения данных от сервера
            DataInputStream is =
                    new DataInputStream(socket.getInputStream());
            // Поток для передачи данных серверу
            DataOutputStream os =
                    new DataOutputStream(socket.getOutputStream());
            while (true) {
                // Отправляем сообщение на сервер

                Scanner scanner = new Scanner(System.in);

                String message = scanner.nextLine();

                // измеряем кол-во байт в сообщении
                int size = message.getBytes().length;

                os.writeInt(size); // заголовок пакета
                os.write(message.getBytes()); // тело пакета
                os.flush();
                if(message.equals("exit")) {
                    break;
                }
                // Читаем послание от сервера

                size = is.readInt(); // размер сообщения
                byte[] buffer = new byte[size]; // готовим буфер нужного размера
                is.read(buffer); // читаем сообщение
                message = new String(buffer);
                System.out.println(message);

                if(message.equals("exit")) {
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}