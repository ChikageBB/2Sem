package org.example;


public class Main{
    public static void main(String[] args) {

        Integer[] arr = {5, 3, 2, 1, 4};
        ListExample listExample = new ListExample(arr);



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