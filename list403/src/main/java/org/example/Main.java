package org.example;


public class Main{
    public static void main(String[] args) {


        ListExample listExample = new ListExample();
        listExample.add(1);
        listExample.add(2);
        listExample.add(3);
        listExample.add(4);
        listExample.add(5);


        System.out.println("------- ВЫВОД СПИСКА -------");
        listExample.print();
        System.out.println();

        System.out.println("------- ДОБАВЛЕНИЕ ЭЛЕМЕНТА ПО ИНДЕКСУ -------");
        listExample.add(9, 1);
        listExample.print();
        System.out.println();

        System.out.println("------- ДОБАВЛЕНИЕ ЭЛЕМЕНТА В КОНЕЦ -------");
        listExample.add(6);
        listExample.print();
        System.out.println();

        System.out.println("------- СОРТИРОВКА СПИСКА ПО НЕВОЗРАСТАНИЮ -------");
        listExample.sort(false);
        listExample.print();
        System.out.println();

        System.out.println("------- СОРТИРОВКА СПИСКА ПО НЕУБЫВАНИЮ -------");
        listExample.sort(true);
        listExample.print();

    }
}