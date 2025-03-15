package ru.itis.inf403.set403.Set;

import java.util.*;


public class SetExample<T>  implements ISet<T>{
    private final int CAPACITY = 16;
    private ListExample<T>[] arr;
    private int size;



    public SetExample(){
        arr = new ListExample[CAPACITY];
        for (int i = 0; i < arr.length; i++){
            arr[i] = new ListExample<>();
        }
        this.size = 0;
    }

    public boolean add(T elem){
        int index = getIndex(elem);
        ListExample<T> bucket = arr[index];

        if (!bucket.contains(elem)){
            bucket.add(elem);
            ++size;
            return true;
        }
        return false;
    }

    public boolean remove(T elem){
        int index = getIndex(elem);
        ListExample<T> bucket = arr[index];

        if (bucket.contains(elem)){
            bucket.remove(elem);
            --size;
            return true;
        }

        return false;
    }

    public void print(){
        System.out.print("{ ");
        for (ListExample<T> bucket: arr){
            for (T elem: bucket){
                System.out.print(elem + " ");
            }

        }
        System.out.println("}");
    }


    public int getIndex(T elem){
        return (elem == null) ? 0 : Math.abs(Objects.hashCode(elem) % arr.length);
    }

}
