package ru.itis.inf403.model;
import ru.itis.inf403.model.Set.*;

import java.util.Set;

public interface Map403<K, V> {
    void put(K key, V value);

    V get(K key);

    ListObj<V> values();

    ISet<K> keySet();

    int size();

    boolean containsKey(K key);

    boolean isEmpty();

    boolean containsValue(V value);

    V remove(K key);

    void clear();

    interface Entry<K, V> {
        void setKey(K key);
        void setValue(V value);
        K getKey();
        V getValue();
    }

}
