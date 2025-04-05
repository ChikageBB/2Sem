package ru.itis.inf403.model;

import ru.itis.inf403.model.list.DoubleLinkedList;
import ru.itis.inf403.model.list.ListExample;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        double countNanoSec = 1_000_000_000.0;
        long start = System.nanoTime();

        ListExample<Integer> list = new ListExample<>();
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        Random r = new Random();


        for (int i = 0; i < 100_000; i++){
            list.add(r.nextInt());
        }

        System.out.println("Intermediate for ArrayList (add elem): " + (double)(System.nanoTime() - start) / countNanoSec + " seconds");

        long removeStart = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            list.remove(i);
        }

        System.out.println("Intermediate for ArrayList (remove elem): " + (double)(System.nanoTime() - removeStart) / countNanoSec + " seconds");


        System.out.println("Result for ArrayList: " + (double)(System.nanoTime() - start) / countNanoSec + " seconds");

        System.out.println("-----------------------------------------------------");

        start = System.nanoTime();

        for (int i = 0; i < 100_000; i++){
            linkedList.addLast(r.nextInt());
        }

        System.out.println("Intermediate result for DoubleLinkedList (add elem): " + (double)(System.nanoTime() - start) / countNanoSec + " seconds");

        removeStart = System.nanoTime();
        for (int i = 10_000 - 1; i >= 0; i--){
            linkedList.removeIn(i);
        }

        System.out.println("Intermediate result for DoubleLinkedList (remove elem): " + (double)(System.nanoTime() - removeStart) / countNanoSec + " seconds");


        System.out.println("Result for DoubleLinkedList: " + (double)(System.nanoTime() - start) / countNanoSec + " seconds");
    }
}
