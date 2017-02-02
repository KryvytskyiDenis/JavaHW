package Collections.Exercise6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/*
* В текстовом файле хранятся список песен, каждая песня из новой строки, данные о песне разделены слешем:
* Название песни/исполнитель/рейтинг песни
* Название песни/исполнитель/рейтинг песни
* …
* Создайте класс Song с требуемыми полями. Отсортируйте и выведите в консоль песни из файла по названию и по исполнителю.
*/
public class MainClass {
    public void readWordsFromFile(TreeSet<Song> treeSet) {
        String line;
        try (Scanner scan = new Scanner(new FileReader("listSongsEx6.txt"))) {
           // scan.useDelimiter("/\n");
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                String[] str = line.split("/");

                treeSet.add(new Song(str[0],str[1], Double.parseDouble(str[2])));
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        TreeSet<Song> treeSet = new TreeSet<>(new MyComparator().thenComparing(new ThenComparator()));

        MainClass mc = new MainClass();

        mc.readWordsFromFile(treeSet);

        //выводим отсортированые песни по исполнителю и по названию(если исполнитель повторяется)
        System.out.println("Песни отсортированы по названию:");
        for (Song s:treeSet) {
            System.out.println(s);
        }
    }
}
