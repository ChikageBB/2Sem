package dz;

import java.util.Random;

public class Task2 {

    public static void main(String[] args){
        Random r = new Random();
        int[] arr = new int[1000];

        for (int i = 0; i < 1000; ++i){
            arr[i] = r.nextInt(100000);
        }

        sort(arr);

        for (int elem: arr){
            System.out.println(elem);
        }

    }


    public static int[] sort(int[] arr) {
        buildHeap(arr);
        int heapSize = arr.length;

       for (int i = arr.length - 1; i > 0; --i){
           swap(arr, 0, i);
           heapSize--;
           siftDown(arr, 0, heapSize);
       }

       return arr;
    }

    public static void siftDown(int[] arr, int i, int heapSize) {
        while (2 * i + 1 < heapSize){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;

            if (right < heapSize && arr[right] > arr[left]) j = right;

            if (arr[i] >= arr[j]) break;

            swap(arr, i, j);
            i = j;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
    }

}
