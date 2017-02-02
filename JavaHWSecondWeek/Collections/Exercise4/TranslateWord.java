package Collections.Exercise4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class TranslateWord {
    private HashMap<String, String> hm = new HashMap<>();

    public void readWordsFromFile() {
        try (Scanner scan = new Scanner(new FileReader("fileWithWords.txt"))) {
            while (scan.hasNextLine()) {
                hm.put(scan.next(), scan.next());
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    public String translateWord(String strInEnglish){
        return hm.get(strInEnglish);
    }
}
