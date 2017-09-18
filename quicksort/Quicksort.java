package com.jeff;

public class Quicksort {

    public static void main(String[] args) {
        int[] arr = {12, 6, 4, 2, 11, 8, 9};
        quicksort(arr, 0, arr.length-1);
        printArray(arr);
    }

    public static void quicksort(int[] arr, int lo, int hi){

        if (lo < hi) {

            int partIndex = partition(arr, lo, hi);

            quicksort(arr, lo, partIndex - 1);
            quicksort(arr, partIndex + 1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi){

        int pivot = arr[hi];
        int i = lo-1;

        for (int j = lo; j < hi; j++){
            if (arr[j] <= pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        int temp = arr[i+1];
        arr[i+1] = arr[hi];
        arr[hi] =  temp;

        return i+1;
    }

    public static void printArray(int[] arr){
        int len = arr.length;
        for (int i=0; i<len; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
