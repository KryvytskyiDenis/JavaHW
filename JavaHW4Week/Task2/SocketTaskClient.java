package Task2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketTaskClient {
    String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.
    Socket socket;
    BufferedReader sin;
    BufferedWriter sout;
    String line;//сообщение пользователя

    SocketTaskClient() {
        try {
            socket = new Socket(address, SocketTaskServer.port);//подключаемся к серверу

            //создаем потоки ввода-вывод для передачи и получения сообщений
            sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sout = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //запускаем работу получения сообщений от других пользователей
            GetMessage getM = new GetMessage();
            getM.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class GetMessage extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    String message = sin.readLine();//получаем сообщения с сервера
                    System.out.println("Получено сообщение: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        while (true) {
            try {
                while (true) {
                    // Создаем поток для чтения с клавиатуры.
                    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Напечатайте сообщение: ");

                    line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.

                    System.out.println("Отправляем это сообщение на сервер...");

                    sout.write(line + "\n"); // отсылаем введенную строку текста серверу.
                    sout.flush(); // заставляем поток закончить передачу данных.
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    sin.close();
                    sout.close();
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new SocketTaskClient().run();//запускаем работу клиента

    }
}
