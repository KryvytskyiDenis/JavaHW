package Collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/*
 * Задание 1
 * Нужно сохранить имена и фамилии всех своих сотрудников в ArrayList.
 * Каждый месяц, работник будет выбран случайным образом из этих записей, чтобы получить премию.
 */
public class Exercise1 {
    public void enterEmployees(ArrayList<String> arrayList) {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите имена и фамилии сотрудников:");
        System.out.println("Введите 'стоп' для завершения.");

        String str;
        try {
            while (true) {
                str = bis.readLine();

                if (str.equals("стоп"))//если введено 'стоп', то выходим из цикла
                    break;

                arrayList.add(str);//помещаем в коллекцию
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int randSelectionEmploee(ArrayList<String> arrayList){
        Random rand = new Random();

        return rand.nextInt(arrayList.size()-1);
    }

    public static void main(String[] args) {
        ArrayList<String> alist = new ArrayList<>();

        Exercise1 newObj = new Exercise1();

        newObj.enterEmployees(alist);//вводим сотрудников

        System.out.println("Ваши сотрудники: " + alist);

        System.out.println("Премию получает: " + alist.get(newObj.randSelectionEmploee(alist)));

    }
}
