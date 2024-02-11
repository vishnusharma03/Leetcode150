package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "s");
        map.put(0,"w");
        System.out.println(map);


        int[] arr = {2, 3, 1, 4, 4, 5};
        int target = 4;
//        findAllIndex(arr, target, 0, new ArrayList<>());
//        System.out.println(RecursionReverse(1534));

//        int[] arr = {4,3,2,7,1,6,5};
//        System.out.println("OG arr: "+ Arrays.toString(arr));
//        CycleSort(arr);
//        System.out.println("Sorted arr: "+ Arrays.toString(arr));
//          System.out.println(56);
//        Integer num = new Integer(56);
//        System.out.println(num.toString());
//        System.out.println(num);
//        System.out.println("Kunal");
//        System.out.println(Arrays.toString(new int[]{2, 3, 4, 5}));
//
//        String name = null;
//        System.out.println(name);
    }

    // If you do not print then you will have trouble in analyzing the answer otherwise in final call
    // it is calculating the right answer.
    public static void findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        System.out.println(list);
        findAllIndex(arr, target, index + 1, list);
    }


    // Wrong Implementation
    public static int RecursionReverse(int n){
        if (n / 10 == 0){
            return n;
        }
        int rem = n % 10;
        return rem*10 + RecursionReverse(n/10);
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
