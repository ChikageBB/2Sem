package ru.itis.inf403.model;

import ru.itis.inf403.model.Set.ISet;
import ru.itis.inf403.model.Set.ListExample;
import ru.itis.inf403.model.Set.ListObj;

public class Main {
    public static void main(String[] args) {

        Map403<Integer, String> map = new MapImpl<>();
        map.put(1, "Привет");
        map.put(2, "Привет");

        System.out.println(map.size());

        System.out.println(map.get(1));

        System.out.println(map.containsKey(15));

        ListObj<String> list = map.values();
        list.print();

        ISet<Integer> set = map.keySet();
        set.print();

        System.out.println(map.remove(2));
    }
}
