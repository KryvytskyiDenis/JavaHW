package kryvytskyi;
import java.util.Scanner;

/*Пользователь вводит с клавиатуры в консоль 10 чисел.
Определить минимум и максимум и вывести их на экран.*/

public class Exercise1 {
    //метож для ввода элементов массива с клавиатуры
    static int[] enterElementsOfArray(int array[]){
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите " + i + "-й элемент:");
            array[i] = scan.nextInt();
        }

        return array;
    }
    //методы поиска максимального значения в массиве
    static int findMaxElement(int array[]){
        int max = 0;
        for (int i = 0; i < 5; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
    //методы поиска минимального значения в массиве
    static int findMinElement(int array[]){
        int min = array[0];
        for (int i = 1; i < 5; i++) {
            if(array[i] < min){
                min = array[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int arr[] = new int[5];//массив чисел
        int maxElement, minElement;//максимум и минимум массива соответсвенно

        arr = enterElementsOfArray(arr);//вызов метода для ввода элементов

        minElement = findMinElement(arr);//вызов метода для поиска максимальнго значения
        maxElement = findMaxElement(arr);//для посика минимального значения

        System.out.println("Минимальное значение: " + minElement);
        System.out.println("Максимальное значение: " + maxElement);

    }
}