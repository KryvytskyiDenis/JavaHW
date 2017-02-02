package kryvytskyi;

/*
Дано массив 5х8, числа находятся в диапазоне [0,100] (созданных случайно).
Определить сумму чисел.
 */

import java.util.Random;

public class Exercise2 {
    //метод заполняет элементы двумерного массива случайными числами в диапазоне [0;100]
    static int[][] fillArray(int arr[][], int rows, int columns){
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = rand.nextInt(100);
            }
        }

        return arr;//вернуть массив
    }
    //метод посдчета суммы элементов массива
    static int calcSumArrayElements(int arr[][], int size1, int size2){
        int sum = 0;//сумма элементов массива

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                sum += arr[i][j];
            }
        }

        return sum;//вернуть сумму
    }
    //метод для вывода массива в консоль
    static void printArray(int arr[][], int rows, int columns){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rows = 5, columns = 8;//размерность массива
        int sumArrayElements;// сумма элементов массива

        int array[][] = new int[rows][columns]; //создаем массив

        array = fillArray(array, rows, columns);//заполняем массив

        sumArrayElements = calcSumArrayElements(array, rows, columns);//подсчет суммы элементов

        printArray(array, rows, columns);//вывод массива

        System.out.println("Сумма элементов массива: " + sumArrayElements);//вывод суммы
    }
}
