package ru.itis.inf403.model.genericsList;


import java.util.Iterator;

public class ListExample<T> implements ListObj<T> , Iterable<T> {

    private int CAPACITY = 16;
    private Object[] arr;
    private int size;


    public ListExample(){
        arr = new Object[CAPACITY];
        this.size = 0;
    }

    public ListExample(T[] arr){
        this.arr = arr;
        this.CAPACITY = (int)(arr.length * 1.5);
        this.size = arr.length;

    }
    // [1, 2, 3, 4, 0 0 0 0] size = 4; capacity = 8;
    @Override
    public T get(int position) throws IndexOutOfBoundsException {

        if (position > size - 1 || position < 0){
            throw new IndexOutOfBoundsException();
        }

        return (T)arr[position];
    }


    @Override
    public T remove(int position) {
        if (position > size - 1 || position < 0){
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = new Object[CAPACITY];

        for (int i = 0; i < position; i++){
            newArr[i] = arr[i];
        }

        for (int i = position ; i < position - 1; i++){
            newArr[i] = arr[i + 1];
        }

        --size;
        T temp = (T)arr[position];
        arr = newArr;
        return temp;

    }


    public boolean remove(T elem){
        Object[] newArr = new Object[CAPACITY];

        int index = -1;

        for (int i = 0; i < size; i++){
            if (arr[i].equals(elem)){
                index = i;
                break;
            }
        }

        if (index == -1){
            return false;
        }

        for (int i = index; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }

        arr[size - 1] = null;
        --size;
        return true;
    }

    public boolean contains(T elem){
        for (int i = 0; i < size; i++){
            if (arr[i].equals(elem)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T element) {

        if (size == arr.length){
            grow();
        }

        arr[size++] = element;
    }

    @Override
    public Integer size() {
        return size;
    }



    @Override
    public void add(T element, int position) {
        if (position > size - 1 || position < 0 ){
            throw new IndexOutOfBoundsException();
        }

        if (size == arr.length){
            grow();
        }

        for (int i = size++; i != position; i-- ){
            arr[i] = arr[i - 1];
        }

        arr[position] = element;
    }

    private void grow(){
        int newCapacity = (int)(arr.length * 1.5);
        Object[] temp = new Object[newCapacity];
        for (int i = 0; i < size; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }


    public void swap(int i, int j){
        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length){
            throw new IndexOutOfBoundsException();
        }

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i = 0 ; i < size - 1; ++i){
            stringBuilder.append(arr[i] + ", ");
        }
        stringBuilder.append(arr[size - 1] + " ]");

        System.out.println(stringBuilder);
    }

    public Iterator<T> iterator(){
        return new ListIterator();
    }


    private class ListIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext(){
            return index < size;
        }

        @Override
        public T next(){
            return (T)arr[index++];
        }


    }
}
