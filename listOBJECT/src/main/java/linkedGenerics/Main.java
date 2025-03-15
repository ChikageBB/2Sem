package linkedGenerics;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {


//        DoubleLinkedList<String> list = new DoubleLinkedList<>();
//        list.addFirst("1");
//        list.addLast("2");
//        list.addLast("3");
//        list.addLast("4");
//        list.addLast("5");
//
//        list.addIn("9", 1);
//
//        list.print();

        DoubleLinkedList<Object> s = new DoubleLinkedList<>();

        s.addLast("1");
        s.addLast("2");
        s.addLast("3");
        s.addLast("4");
        s.addIn("9",1);
        s.print();
        int a = 5;
        System.out.println(Objects.hash(a));

    }
}
