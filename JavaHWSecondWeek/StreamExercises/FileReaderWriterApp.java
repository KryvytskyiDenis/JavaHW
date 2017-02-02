package StreamExercises;

import java.io.*;

/*
 * Пользователь вводит в консоль некоторое сообщение, которе мі сохраняем в файл, читаем с файла
 * и выводим в консоль(использовать символьные потоки)
 */
public class FileReaderWriterApp {
    public String readLine() {
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите строку: ");
            line = br.readLine();//считываем строку
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public void fileWriter(String string) {
        try (FileWriter fwrite = new FileWriter(new File("FileReaderWriterAppText.txt"))) {
            fwrite.write(string);
        } catch (FileNotFoundException f) {
            f.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileReaderAndOutput() {

        try (FileReader fread = new FileReader("FileReaderWriterAppText.txt")) {
            int i;

            while ((i = fread.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (FileNotFoundException f) {
            f.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String str;

        FileReaderWriterApp frwapp = new FileReaderWriterApp();
        str = frwapp.readLine();//считать строку

        frwapp.fileWriter(str);//помещаем строку в файл

        frwapp.fileReaderAndOutput();//считать строку с файла и вывести в консоль

    }
}

