package kryvytskyi;

import java.util.Random;
import java.util.Arrays;
/*
    Реализовать сортировку пузырьком в обратном порядке
 */
public class Exercise4 {
    //метод заполняет элементы двумерного массива случайными числами
    static int[] fillArray(int arr[], int sizeArr){
        Random rand = new Random();

        for (int i = 0; i < sizeArr; i++) {
            arr[i] = rand.nextInt(100);
        }

        return arr;//вернуть массив
    }

    //метод сортировки массива пузырьком в обратном порядке, то-есть от большего к меньшему
    public static int[] bubbleSort(int arr[], int sizeArr)
    {
        for (int i = 0; i < sizeArr; i++) {
            for (int j = sizeArr-1 ; j > 0; j--) {
                /*Сравниваем соседние элементы,
                   если порядок неправильный, то меняем местами
                 */
                if(arr[j-1] < arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        final int SIZEARR = 10;//размер массива
        int array[] = new int[SIZEARR];//создаем массив для 10 элементов

        array = fillArray(array, SIZEARR);//заполняем массив случайными числами

        System.out.println("Массив до сортировки:");
        System.out.println(Arrays.toString(array));

        array = bubbleSort(array, SIZEARR);
        System.out.println("Массив после сортировки:");
        System.out.println(Arrays.toString(array));

    }
}
