import java.util.Arrays;

public class Mergesort{

    public static void main(String args[]){
        int[] arr = {4, 2, 8, 1, 3, 10, 9};
        System.out.println("BEFORE MERGESORT: " + Arrays.toString(arr));
        mergesort(arr, 0, arr.length-1);
        System.out.println("AFTER MERGESORT: " + Arrays.toString(arr));
    }

    public static void mergesort(int[] arr, int left, int right){
        if (left < right){
            int mid = (left + right) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int lenL = mid-left+1;
        int lenR = right-mid;

        int[] L = new int [lenL];
        int[] R = new int [lenR];

        for (int i=0; i<lenL; i++){
            L[i] = arr[left+i];
        }
        for (int i=0; i<lenR; i++){
            R[i] = arr[mid+1+i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while ((i < lenL) && (j < lenR)){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i<lenL){
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j<lenR){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
