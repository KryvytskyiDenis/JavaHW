package Collections.Exercise6;

import java.util.Comparator;

//Второй компаратор, если один исполнитель. Отсортировать песни по названию
public class ThenComparator implements Comparator<Song>{
    @Override
    public int compare(Song s1, Song s2) {
        return s1.getSong().compareTo(s2.getSong());
    }
}
