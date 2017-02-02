package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 *Есть список сотрудников, которые есть имя фамилия и уникальный номер сотрудника.
 *Получить сотрудника по уникальному ключу.
 */
public class Exercise3 {
    public String getEmploeeByKey(HashMap<Integer, String> hm, int key){
        return hm.get(key);
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();

        hm.put(1,"Денис Кривицкий");
        hm.put(2,"Виктория Величко");
        hm.put(3, "Дарья Клименко");
        hm.put(4, "Сергей Лещенко");
        hm.put(5, "Илья Сузима");
        hm.put(6, "Василий Исак");
        hm.put(7, "Юрий Пастухов");

        Exercise3 obj = new Exercise3();
        System.out.println(obj.getEmploeeByKey(hm, 5));
    }
}
