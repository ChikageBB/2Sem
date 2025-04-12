package ru.itis.inf403.lab2_06.graph;

import java.util.*;

public class Graph implements Iterable<Character> {
    private Map<Character, Set<Character>> graph = new HashMap();

    public Graph(){
        graph = new HashMap<>();
        graph.put('d', null);
        graph.put('a', new HashSet<>(Set.of('d', 'c')));
        graph.put('f', new HashSet<>(Set.of('d')));
        graph.put('g', new HashSet<>(Set.of('d')));
        graph.put('c', null);
        graph.put('b', new HashSet<>(Set.of('g', 'f', 'c', 'a')));
    }
    // {{d, null}}}
    //res: {d,
    public Set<Character> topolSort(){
        Set<Character> res = new LinkedHashSet<>();
        Map<Character, Set<Character>> temp = new HashMap<>();

        //копирование графа
        for (Map.Entry<Character, Set<Character>> elem: graph.entrySet()){
            temp.put(elem.getKey(), elem.getValue() == null ? null : new HashSet<>(elem.getValue()));
        }


        // пока HashMap не пустой совершаем итерации
        while (!temp.isEmpty()){
            Character removeChar = null;

            // ищем null-вершину
            for (Map.Entry<Character, Set<Character>> etr: temp.entrySet()){
                if (etr.getValue() == null || etr.getValue().isEmpty()) {
                    removeChar = etr.getKey();
                    break;
                }
            }

            //если вершины нет, выбрасываем ошибку, что граф цикличный
            if (removeChar == null){
                throw new RuntimeException();
            }

            //добавляем вершину в результат
            res.add(removeChar);
            //удаляем вершину с ключей
            temp.remove(removeChar);

            //удаляем вершину из множеств
            for (Set<Character> set: temp.values()){
                if (set != null){
                    set.remove(removeChar);
                }
            }
        }
        return res;
    }

    @Override
    public Iterator<Character> iterator(){
        Character[] arr = topolSort().toArray(new Character[0]);
        return new Iterator<Character>() {


            int index = 0;

            @Override
            public boolean hasNext() {
                return index < arr.length;
            }

            @Override
            public Character next() {
                return arr[index++];
            }
        };
    }

}
