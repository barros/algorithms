package com.jeff;

public class BinarySearch {

    public static void main(String[] args) {
	    int arr[] = {5, 10, 15, 20, 25, 30};
	    int result = binarySearch(arr, 0, arr.length-1, 19);
	    if (result == -1) {
            System.out.println("Element not found");
        } else{
            System.out.println("Element found at index: " + result);
        }
    }



    public static int binarySearch(int arr[], int first, int last, int val){
        int mid = (first + last) / 2;

        if (arr[mid] == val) {
            return mid;
        } else if (first == last){
        	return -1;
        } else if (arr[mid] > val){
            return binarySearch(arr, first, mid-1, val);
        } else {
            return binarySearch(arr, mid+1, last, val);
        } 
    }
}
