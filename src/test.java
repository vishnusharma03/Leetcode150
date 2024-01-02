package src;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,1,6,5};
        System.out.println("OG arr: "+ Arrays.toString(arr));
        CycleSort(arr);
        System.out.println("Sorted arr: "+ Arrays.toString(arr));
    }

    // Cycle Sort

    public static void CycleSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else {
                i++;
            }
        }
    }

    // Implementing Insertion Sort
    public static void InsertionSort(int[] arr){
        int n = 0;
        while(n < arr.length-1){
            int i = n;
            int j = n+1;
            while(arr[i] > arr[j]){
                swap(arr, i, j);
                i--;
                j--;

                if(i < 0)
                    break;
            }
            n++;
        }
    }

    // Implementing Bubble Sort Algorithm
    public static void buublesort(int[] arr){
        int n = 0;
        while(arr.length-n > 0){
            int i = 0;
            int j = 1;
            while(i < arr.length-1){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
                i++;
                j++;
            }
            n++;
        }
    }

    private static void swap(int[] arr , int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Implementing Selection Sort
    public static void SelectionSort(int[] arr) {

        for (int j = 0; j < arr.length; j++) {
            int max = arr[0];
            int index = 0;
            for (int i = 0; i < arr.length-j; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    index = i;
                }
            }
            swap(arr, index, arr.length - j - 1);
        }
    }
}
