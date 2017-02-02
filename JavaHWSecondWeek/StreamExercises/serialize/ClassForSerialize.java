package StreamExercises.serialize;

import java.io.Serializable;

public class ClassForSerialize implements Serializable{
    private int count = 2;
    private Color color = new Color();

    @Override
    public String toString() {
        return "ClassForSerialize{" +
                "count=" + count +
                ", color=" + color +
                '}';
    }
}


