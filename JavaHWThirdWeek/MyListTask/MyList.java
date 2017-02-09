package MyListTask;

import java.util.ArrayList;
import java.util.List;

/*
 * Есть класс Node(элемент односвязного списка) в котором есть
 * поле next типа Node(ссылка на следующий элемент) и int поле elem.
 * Реализовать метод который будет принимать Node node (ссылка на первый элемент списка)
 * и возвращать список в обратном порядке.
 */
public class MyList {
    //метод позвращает ссылку на последний элемент, который после реверса является  первым элементов списка
    public Node reverseList(Node firstNode) {
        Node temp = reverse(firstNode, firstNode.getNext());//Переменной temp присваиваем ссылку на последний элемент списка
        firstNode.setNext(null);//первый элемент теперь последний его поле next = null
        return temp;
    }

    /*При первом вызове методу передается ссылки на первые два элемента.
    Если элемент, переданный 2-у параметру существует, то этот элемент теперь ссылается на первый, а метод рекурсивно вызывает себя,
    а в качестве параметров ему передаются current элемент и следующий за ним
    Если второй параметр null, то метод возвращает последний элемент списка
     */
    public Node reverse(Node previous, Node current) {
        if (current == null) {
            return previous;
        }

        Node pr = current;
        Node cur = current.getNext();

        current.setNext(previous);

        return reverse(pr, cur);
    }

    public Node addNodeToList(int size) {
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < size; i++) {
            nodes[i].setElem(i);//задаем значение поля elem
            //инициализируем значения ссылок node. Последний элемент не ссылается ни на что, значение его next = null
            if (i < size - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
        }

        return nodes[0];//возвращаем первый элемент односвязного списка
    }

    public void printList(Node node, int size) {
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                System.out.print(node + "->");
            } else {
                System.out.print(node);
            }
            node = node.getNext();//к следующему элементу
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyList list = new MyList();

        int size = 7;

        Node node = list.addNodeToList(size);//присваиваем ссылку на первый элемент списка
        System.out.println("Односвязный список:");
        list.printList(node, size);//выводим список

        node = list.reverseList(node);//присваиваем ссылку на последний элемент
        System.out.println("Список в обратном порядке:");
        list.printList(node, size);//выводим список
    }
}