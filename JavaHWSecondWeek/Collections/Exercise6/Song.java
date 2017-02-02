package Collections.Exercise6;

public class Song {
    private String songName;
    private String singerName;
    private double rating;


    Song(String songName, String singerName, double rating){
        this.songName = songName;
        this.singerName = singerName;
        this.rating = rating;
    }

    String getSong(){
        return songName;
    }
    String getSingerName(){
        return singerName;
    }

    @Override
    public String toString() {
        return "Song{" +
                "название песни='" + songName + '\'' +
                ", исполнитель='" + singerName + '\'' +
                ", рейтинг=" + rating +
                '}';
    }
}
