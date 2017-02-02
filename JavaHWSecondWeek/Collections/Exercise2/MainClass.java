package Collections.Exercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Напишите класс Student, предоставляющий информацию об имени студента методом getName() и о его курсе методом getCourse().
 * Напишите метод printStudents(List students, int course), который получает список студентов и номер курса
 * и печатает в консоль имена тех студентов из списка, которые обучаются на данном курсе. Для обхода списка в этом методе используйте итератор.
 * Протестируйте ваш метод (для этого предварительно придется создать десяток объектов класса Student и поместить их в список).
 */
public class MainClass {
    public void printStudents(List<Student> students, int course) {
        Iterator<Student> itr = students.iterator();
        System.out.print("Студенты " + course + "-го курса: ");
        while (itr.hasNext()) {
            Student student = itr.next();
            if (student.getCourse() == course) {
                System.out.print(student.getName() + ", ");
            }
        }
        System.out.println();
    }

    public void createStudents(List<Student> studList) {
        //создаем десяток объектов класса Student
        Student studArray[] = {
                new Student("Денис", 2),
                new Student("Влад", 4),
                new Student("Андрей", 5),
                new Student("Александр", 2),
                new Student("Василий", 2),
                new Student("Виктория", 4),
                new Student("Мария", 3),
                new Student("Дарья", 5),
                new Student("Сергей", 1),
                new Student("Артем", 1),
        };

        //помещаем созданные объекты в список studList типа ArrayList
        for (int i = 0; i < studArray.length; i++) {
            studList.add(studArray[i]);
        }
    }

    public static void main(String[] args) {
        List<Student> studList = new ArrayList<>(10);

        MainClass obj = new MainClass();

        obj.createStudents(studList);//заполняем список обьектами класса Student
        obj.printStudents(studList, 1);
        obj.printStudents(studList, 2);
        obj.printStudents(studList, 3);
        obj.printStudents(studList, 4);
        obj.printStudents(studList, 5);
    }
}
