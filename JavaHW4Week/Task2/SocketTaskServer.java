package Task2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SocketTaskServer implements Runnable{
    ArrayList<ConnectClient> clients = new ArrayList<>();//список-массив потоков соединений с клиентами
    static int port = 7800; // порт для подключения
    ServerSocket ss; // создаем сокет сервера

    SocketTaskServer(){
        try {
            ss = new ServerSocket(port);//привязываем сокет сервер к вышеуказанному порту
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //внутренний класс - соединение с клиентом
    private class ConnectClient extends Thread{
        BufferedReader sin = null;
        BufferedWriter sout = null;
        Socket socketClient = null;
        private String line;//строка текста - сообщение клиента

        ConnectClient(Socket socketClient){
            this.socketClient = socketClient;
            try {
                sin = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
                sout = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            }catch(IOException e){
                e.getMessage();
            }
        }

        public void run() {
            while(true){
                try {
                    line = sin.readLine();//ждем , когда клиент пришлет строку
                    System.out.println("Отправляем полученную строку...");

                    //отсылаем строку всем остальным клиентам
                        for(ConnectClient c: clients){
                            c.sout.write(line + "\n");
                            c.sout.flush();
                        }
                }catch(IOException e){
                    e.getMessage();
                }
            }

        }
    }

    public void run() {
        while(true){
            try{
                System.out.println("Ожидаем клиентов...");
                Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
                ConnectClient newClient = new ConnectClient(socket);//создаем связь с клиентом
                clients.add(newClient);//добавляем в список клиентов
                newClient.start();//запускаем поток для общения с клиентом

                //сообщаем всем клиентам, что +1 клиент присоединился
                for (ConnectClient client: clients) {
                    client.sout.write("Еще один пользователь присоединился!\n");
                    client.sout.flush();
                }
            }catch(IOException e){
                e.getMessage();
            }
        }
    }

    public static void main(String[] args) {
        new SocketTaskServer().run();//запускаем сервер
    }
}
