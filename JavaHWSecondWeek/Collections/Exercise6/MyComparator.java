package Collections.Exercise6;

import java.util.Comparator;

//основной компаратор, сортировка по исполнителю
public class MyComparator implements Comparator<Song> {
    @Override
    public int compare(Song s1, Song s2) {
        return s1.getSingerName().compareTo(s2.getSingerName());
    }
}
