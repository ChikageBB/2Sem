package ru.itis.inf403.model.Set;
import ru.itis.inf403.model.genericsList.*;

public class SetExample<T>  implements ISet<T>{
    private  int CAPACITY = 16;
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

        if (size == arr.length){
            grow();
        }

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

    public void getAll(){

        for (int i = 0; i < size; i++){
            arr[i].print();
        }
    }


    public boolean contains(T elem){
        for (ListExample<T> bucket: arr){
            if (bucket.contains(elem)){
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return size;
    }

    public int getIndex(T elem){
        //return (elem == null) ? 0 : Math.abs(Objects.hashCode(elem) % arr.length);
        return (elem == null) ? 0 : Math.abs(elem.hashCode() % CAPACITY);
    }

    private void grow(){
        CAPACITY = (int)(arr.length * 1.5);
        ListExample<T>[] temp = new ListExample[CAPACITY];

        for (int i = 0; i < CAPACITY; i++){
            temp[i] = new ListExample<>();
        }

        for (int i = 0; i < size; i++){
            temp[i] = arr[i];
        }

        arr = temp;
    }

}
