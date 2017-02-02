package Collections.Exercise2;

public class Student {
    private String name;//имя студента
    private int course;

    Student(String name, int course){
        this.name = name;
        this.course = course;
    }
    public String getName(){
        return name;
    }

    public int getCourse(){
        return course;
    }
}
