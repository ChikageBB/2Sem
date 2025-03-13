package org.example;


public class Main{
    public static void main(String[] args) {


        ListExample listExample = new ListExample();
        listExample.add(1);
        listExample.add(2);
        listExample.add(3);
        listExample.add(4);
        listExample.add(5);



        listExample.print();
        System.out.println("----------------");

        listExample.add(9, 1);
        listExample.print();
        System.out.println("----------------");


        listExample.add(6);
        listExample.print();
        System.out.println("----------------");

        listExample.sort(false);
        listExample.print();

    }
}