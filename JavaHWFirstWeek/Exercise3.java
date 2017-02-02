package kryvytskyi;

import java.util.Arrays;
/*
Дано массив из 10 случайных элементов.
Скопировать первые три элемента в конец этого же массива.
 */
public class Exercise3 {
    public static void main(String[] args) {
        int[] arr = { 4, 41, 5, 67, 9, 32, 56, 31, 77, 80}; //создаем массив

        System.out.println(Arrays.toString(arr));//выводим массив в консоль

        System.arraycopy(arr,0,arr,7, 3);//копируем первые три элемента в конец этого же массива
        System.out.println(Arrays.toString(arr));//выводим обновленный массив в консоль
    }
}

