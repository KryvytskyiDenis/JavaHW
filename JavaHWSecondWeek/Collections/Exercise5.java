package Collections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/*
* В текстовом файле хранятся названия песен, каждая песня с новой строки.
* Нужно вывести в консоль отсортированные по алфавиту все песни из файла.
*/
public class Exercise5 {
    public void readWordsFromFile(SortedSet<String> treeSet) {
        try (Scanner scan = new Scanner(new FileReader("listSongs.txt"))) {
            while (scan.hasNextLine()) {
                treeSet.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        SortedSet<String> treeSet = new TreeSet<>();

        Exercise5 ex = new Exercise5();
        ex.readWordsFromFile(treeSet);

        for(String s:treeSet){
            System.out.println(s);
        }
    }
}
