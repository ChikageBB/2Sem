package generics;


public class ListExample<T> implements ListObj<T> {

    private int CAPACITY = 15;
    private Object[] arr;
    private int size;


    public ListExample(){
        arr = new Object[CAPACITY];
        this.size = 0;
    }

    public ListExample(int CAPACITY){
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

        T temp = (T)arr[position];
        arr[position] = null;
        return temp;

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
        Object[] temp = new Object[(int)(CAPACITY * 1.5)];
        for (int i = 0; i < size; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

//    @Override
//    public void sort(boolean flag) {
//        if (flag) {
//            for (int i = 0; i < size - 1; i++) {
//                for (int j = i + 1; j < size; j++) {
//                    if (arr[i] > arr[j]) {
//                        Integer temp = arr[i];
//                        arr[i] = arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        } else {
//            for (int i = 0; i < size - 1; i++) {
//                for (int j = i + 1; j < size; j++) {
//                    if (arr[i] < arr[j]) {
//                        Integer temp = arr[i];
//                        arr[i] = arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        }
//    }


//    public void print(){
//        System.out.print("[");
//        for (int i = 0; i < size - 1; i++){
//            System.out.print(arr[i] + ", ");
//        }
//        System.out.print(arr[size - 1]);
//        System.out.println("]");
//    }

    public void print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i = 0 ; i < size - 1; ++i){
            stringBuilder.append(arr[i] + ", ");
        }
        stringBuilder.append(arr[size - 1] + " ]");

        System.out.println(stringBuilder);
    }
}
