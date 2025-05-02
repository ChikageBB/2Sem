package linkedGenerics;

public class DoubleLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;


    public void addFirst(T value){
        Node newNode = new Node(value);
        if (head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        ++size;
    }

    public void addIn(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Выход за пределы списка");
        }

        Node newNode = new Node(value);

        if (index == 0) { // Вставка в начало списка
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) { // Если список был пуст
                tail = newNode;
            }
        } else if (index == size) { // Вставка в конец списка
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else { // Вставка в середину списка
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }

        size++;

    }

    public void addLast(T value){
        Node newNode = new Node(value);

        if (tail == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        ++size;
    }

    public int size(){
        return size;
    }

    public void removeLast(){
        if (tail == null){
            throw new IllegalStateException("DoubleLinkedList is empty");
        }else {
            tail = tail.prev;
            if (tail == null){
                head = null;
            }else {
                tail.next = null;
            }
        }
    }

    public void removeFirst(){
        if (head == null){
            throw new IllegalStateException("DoubleLinkedList is empty");
        }else{
            head = head.next;
            if (head == null){
                tail = null;
            }else{
                head.prev = null;
            }
        }
    }

    public void print(){
        Node current = head;
        while (current != null){
            System.out.println(current.value+ " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reversePrint(){
        Node current = tail;
        while (current != null){
            System.out.println(current.value+ " ");
            current = current.prev;
        }
        System.out.println();
    }


    class Node {
        public T value;
        public Node next;
        public Node prev;

        public Node(T value){
            this.value = value;

        }
    }
}
