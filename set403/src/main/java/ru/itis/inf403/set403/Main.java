package ru.itis.inf403.set403;

import ru.itis.inf403.set403.Set.ListExample;
import ru.itis.inf403.set403.Set.SetExample;


import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        SetExample<String> names = new SetExample<>();
        names.add("blue");
        names.add("red");
        names.add("green");
        names.add("2");

        names.print();


        System.out.println(Objects.hash(3) % 16);




    }
}
