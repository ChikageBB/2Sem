package org.example;

import java.util.*;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        List<String> names = new LinkedList<>();
        names.add("Roman");
        names.add("Egor");
        names.add("Sofa");

        ListIterator<String> iter = names.listIterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    public static void sort(int[] arr){

//        for (int i = 0; i < arr.length; i++){
//            for (int j = 0; j < arr.length - 1; j++){
//                if (arr[j] > arr[j + 1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }


//        for (int k = 0; k < arr.length - 1; k++){
//            for (int j = k + 1; j < arr.length; j++){
//                if (arr[k] > arr[j]){
//                    int temp = arr[k];
//                    arr[k] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        int n = arr.length;

//        for (int k = 1; k < n; k++){
//            for (int j = k; j > 0 && arr[j - 1] > arr[j]; j--){
//                int temp = arr[j - 1];
//                arr[j - 1] = arr[j];
//                arr[j] = temp;
//                System.out.println(Arrays.toString(arr));
//            }
//        }

//[1, 2, 3, 7, 8, 9, 5, 6, 4]
//[1, 2, 3, 7, 8, 5, 9, 6, 4]
//[1, 2, 3, 7, 5, 8, 9, 6, 4]
//[1, 2, 3, 5, 7, 8, 9, 6, 4]
//[1, 2, 3, 5, 7, 8, 6, 9, 4]
//[1, 2, 3, 5, 7, 6, 8, 9, 4]
//[1, 2, 3, 5, 6, 7, 8, 9, 4]
//[1, 2, 3, 5, 6, 7, 8, 4, 9]
//[1, 2, 3, 5, 6, 7, 4, 8, 9]
//[1, 2, 3, 5, 6, 4, 7, 8, 9]
//[1, 2, 3, 5, 4, 6, 7, 8, 9]
//[1, 2, 3, 4, 5, 6, 7, 8, 9]


//[1, 2, 3, 5, 9, 8, 7, 6, 4]
//[1, 2, 3, 4, 9, 8, 7, 6, 5]
//[1, 2, 3, 4, 8, 9, 7, 6, 5]
//[1, 2, 3, 4, 7, 9, 8, 6, 5]
//[1, 2, 3, 4, 6, 9, 8, 7, 5]
//[1, 2, 3, 4, 5, 9, 8, 7, 6]
//[1, 2, 3, 4, 5, 8, 9, 7, 6]
//[1, 2, 3, 4, 5, 7, 9, 8, 6]
//[1, 2, 3, 4, 5, 6, 9, 8, 7]
//[1, 2, 3, 4, 5, 6, 8, 9, 7]
//[1, 2, 3, 4, 5, 6, 7, 9, 8]
//[1, 2, 3, 4, 5, 6, 7, 8, 9]

//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < n - 1; j++){
//                if (arr[j] > arr[j + 1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    System.out.println(Arrays.toString(arr));
//                }
//            }
//        }


        for (int i = 0; i < n - 1; i++){
            int minInd = i;
            for (int j = i + 1; j <n; j++ ){
                if (arr[j] > arr[i]){
                    minInd = j;
                }

                int temp = arr[minInd];
                arr[minInd] = arr[i];
                arr[i] = temp;


            }
        }

    }
}
