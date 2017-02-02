package Collections.Exercise7;

import java.util.ArrayList;
import java.util.List;

/*
 * Есть класс Node(элемент односвязного списка) в котором есть
 * поле next типа Node(ссылка на следующий элемент) и int поле elem.
 * Реализовать метод который будет принимать Node node (ссылка на первый элемент списка)
 * и возвращать список в обратном порядке.
 */
public class Main {
    public List convertList(Node first) {
        List<Node> newList = new ArrayList<>();
        int countNodeElements = 0;
        Node node = first;
        //высчитываем кол-во элементов
        while(node.getNext() != null){
            node = node.getNext();
            countNodeElements++;
        }

        node = first;//ссылка на первый элемент

        for (int i = 0; i <= countNodeElements; i++) {
            newList.add(returnNodeToNewList(node, countNodeElements - i));
        }

        return newList;
    }

    public Node returnNodeToNewList(Node node, int countNodeElements){
        for (int i = 0; i < countNodeElements; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void addNodeToList(List<Node> list) {
        int size = 10;
        for (int i = 0; i < size; i++) {
            list.add(new Node());
            list.get(i).setElem(i);
        }
        for (int i = 0; i < size; i++) {
            //инициализируем значения ссылок node. Последний элемент не ссылается ни на что, значение его next = null
            if (i < size-1) {
                list.get(i).setNext(list.get(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Main main = new Main();

        main.addNodeToList(list);

        System.out.println(list);

        list = main.convertList(list.get(0));

        System.out.println(list);
    }
}