package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample implements List403 {

    private int CAPACITY = 15;
    private Integer[] arr;
    private int size;


    public ListExample(){
        arr = new Integer[CAPACITY];
    }

    public ListExample(Integer[] arr){
        this.arr = arr;
    }
    // [1, 2, 3, 4, 0 0 0 0] size = 4; capacity = 8;
    @Override
    public Integer get(int position) throws IndexOutOfBoundsException {

        if (position > size - 1 || position < 0){
            throw new IndexOutOfBoundsException();
        }

        return arr[position];
    }


    @Override
    public Integer remove(int position) {
        if (position > size - 1 || position < 0){
            throw new IndexOutOfBoundsException();
        }

        Integer temp = arr[position];
        arr[position] = null;
        return temp;

    }

    @Override
    public void add(Integer element) {

        if (CAPACITY == arr.length){
            grow();
        }

        arr[size++] = element;
    }

    @Override
    public Integer size() {
        return size;
    }



    @Override
    public void add(Integer element, int position) {
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
        Integer[] temp = new Integer[(int)(CAPACITY * 1.5)];
        for (int i = 0; i < size; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    @Override
    public void sort(boolean flag) {
        if (flag) {
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (arr[i] > arr[j]) {
                        Integer temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (arr[i] < arr[j]) {
                        Integer temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }


    public void print(){
        System.out.print("[");
        for (int i = 0; i < size - 1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[size - 1]);
        System.out.println("]");
    }
}
