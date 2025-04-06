package ru.itis.inf403.model;

import ru.itis.inf403.model.Set.ISet;
import ru.itis.inf403.model.Set.ListExample;
import ru.itis.inf403.model.Set.ListObj;

public class Main {
    public static void main(String[] args) {

        Map403<Integer, String> map = new MapImpl<>();
        map.put(1, "Привет");
        map.put(2, "Привет");


        for (Map403.Entry<Integer, String> item : map){
            System.out.println(item.getKey() + " : " + item.getValue());
        }

        map.clear();


    }
}
