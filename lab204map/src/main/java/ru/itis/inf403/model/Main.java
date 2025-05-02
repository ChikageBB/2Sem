package ru.itis.inf403.model;

import ru.itis.inf403.model.Set.ListObj;

public class Main {
    public static void main(String[] args) {

        Map403<Integer, String> map = new MapImpl<>();
        map.put(16,"16"); map.put(17,"17"); map.put(18,"18"); map.put(19,"19");
        map.put(20,"20"); map.put(21,"21"); map.put(22,"22"); map.put(23,"23");
        map.put(24,"24"); map.put(25,"25"); map.put(26,"26"); map.put(27,"27");
        map.put(28,"28"); map.put(29,"29"); map.put(30,"30"); map.put(31,"31");
        map.put(32,"32");


        for (Map403.Entry<Integer, String> entry: map){
            System.out.println(entry.getValue());
        }

    }
}
