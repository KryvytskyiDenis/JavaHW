package Collections.Exercise7;

/*
 * Класс Node(элемент односвязного списка)
 */
public class Node {
    private Node next;
    private int elem;

    Node() {
        this.next = null;
        this.elem = 0;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public int getElem() {
        return elem;
    }

    @Override
    public String toString() {
        return "Node{elem = " + elem + '}';
    }
}
