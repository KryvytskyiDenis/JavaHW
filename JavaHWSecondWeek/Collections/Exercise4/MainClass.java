package Collections.Exercise4;

/*
 Есть текстовый файл в котором хранятся перевод слов для словаря.
 Содержимое файла:
 white белый
 black черный
 red красный
 …

 Реализовать метод который будет принимать на вход слово на английском а возвращать результат перевода на русском.
 */

public class MainClass {
    public static void main(String[] args) {
        TranslateWord translate = new TranslateWord();

        translate.readWordsFromFile();

        System.out.println(translate.translateWord("red"));
    }
}