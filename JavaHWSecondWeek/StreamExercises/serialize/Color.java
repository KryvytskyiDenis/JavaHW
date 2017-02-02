package StreamExercises.serialize;

import java.io.Serializable;

//класс может быть сериализован только, если он реализует интерфейс Serializable
//так как в классе ClassForSerialize есть ссылка на обьект класса Color, то обьект типа Color так же будет сериализован
public class Color implements Serializable {
    private int num = 583;
    private String name = "Denis";

    @Override
    public String toString() {
        return "Color{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}