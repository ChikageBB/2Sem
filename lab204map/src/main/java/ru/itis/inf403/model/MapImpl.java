package ru.itis.inf403.model;

import ru.itis.inf403.model.Set.ISet;
import ru.itis.inf403.model.Set.ListExample;
import ru.itis.inf403.model.Set.ListObj;
import ru.itis.inf403.model.Set.SetExample;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class MapImpl<K, V> implements Map403<K, V>{

    private Node<K, V>[] arr;
    private int size;

    public MapImpl(){
        arr = new Node[16];
    }

    @Override
    public void put(K key, V value) {
        reHash();
        int index = Math.abs(key.hashCode()) % arr.length;

        Node<K, V> temp = new Node<>(key, value);

        if (arr[index] == null){
            arr[index] = temp;
        }else{
            Node current = arr[index];
            while (current.next != null){
                if (current.value.getKey().equals(temp.value.getKey())){
                    current.value.setValue(value);
                    return;
                }
                current = current.next;
            }
            current.next = temp;
        }
        size++;
    }

    @Override
    public V get(K key) {
       int index = Math.abs(key.hashCode()) % arr.length;

       if (arr[index] == null){
           return null;
       }

       Node<K, V> current = arr[index];
       while (current != null){
            if (current.value.getKey().equals(key)){
                return current.value.getValue();
            }
            current = current.next;
       }
       return null;
    }

    @Override
    public ListObj<V> values() {
        ListExample<V> list = new ListExample<>();

        for (Node<K, V> node: arr){
            while (node != null){
                list.add(node.value.getValue());
                node = node.next;
            }
        }

        return list;
    }

    @Override
    public ISet<K> keySet() {
        ISet<K> set = new SetExample<>();

        for (Node<K, V> node: arr){
            while (node != null){
                set.add(node.value.getKey());
                node = node.next;
            }
        }
        return set;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        int index = Math.abs(key.hashCode()) % arr.length;

        if (arr[index] == null){
            return false;
        }

       Node<K, V> current = arr[index];
       while (current != null){
            if (current.value.getKey().equals(key)){
                return true;
            }
            current = current.next;
       }
       return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < arr.length; i++){
            Node<K, V> current = arr[i];
            while (current != null){
                if (current.value.getValue().equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashCode()) % arr.length;

        Node<K, V> current = arr[index];
        Node<K, V> previous = null;

        while (current != null){
            if (current.value.getKey().equals(key)) {
                V removedValue = current.value.getValue();

                if (previous == null){
                    arr[index] = current.next;
                }else{
                    previous.next = current.next;
                }
                size--;
                return removedValue;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    private void reHash(){
        if (size >= arr.length * 0.75){
            Node<K, V>[] oldArr = arr;
            arr = new Node[oldArr.length * 2];
            size = 0;

            for (Node<K, V> node: oldArr){
                while (node != null){
                    put(node.value.getKey(), node.value.getValue());
                    node = node.next;
                }
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < arr.length; i++){
            arr[i] = null;
        }
    }


     class EntryImpl<K, V> implements Entry<K, V>{
        private K key;
        private V value;

        public EntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    private class Node<K, V>{
        Entry<K, V> value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.value = new EntryImpl<>(key, value);
        }
    }

    public Iterator<Entry<K, V>> iterator(){
        return new MapIterator();
    }

    private class MapIterator implements Iterator<Entry<K, V>>{
        private int currentIndex = 0;
        private Node<K, V> currentNode = null;
        private int returnedCount = 0;


        @Override
        public boolean hasNext() {
            return returnedCount < size;
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            while (currentNode == null){
                if (currentIndex >= arr.length){
                    throw new NoSuchElementException();
                }

                currentNode = arr[currentIndex++];
            }

            Entry<K, V> result = currentNode.value;
            currentNode = currentNode.next;
            returnedCount++;
            return result;
        }
    }
}

