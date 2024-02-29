package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {

        System.out.println((int)(Math.pow(10,0)));
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put(0, "s");
//        map.put(0,"w");
//        System.out.println(map);
//        int[] arr1 = {2};
//        int[] arr2 = {3,5};
//        System.out.println(kth(arr1, arr2, 2, 1, 1));
//
//
//        int target = 4;
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

    public static int kth(int[] arr1, int[] arr2, int n, int m, int k) {
        // base cases
        if (n == 1 || m == 1) {
            // if one array is empty or only has one element, find the kth element in the other array
            if (m == 1) {
                int[] temp = arr1;
                arr1 = arr2;
                arr2 = temp;
                m = n;
            }
            if (k == 1) {
                return Math.min(arr1[0], arr2[0]);
            } else if (k == m + 1) {
                return Math.max(arr1[0], arr2[0]);
            } else {
                if (arr2[k - 1] < arr1[0]) {
                    return arr2[k - 1];
                } else {
                    return Math.max(arr1[0], arr2[k - 2]);
                }
            }
        }

        int mid1 = (n - 1) / 2;
        int mid2 = (m - 1) / 2;

        if (mid1 + mid2 + 1 < k) {
            // if k is greater than the sum of midpoints, discard the smaller half of the arrays and recurse
            if (arr1[mid1] < arr2[mid2]) {
                return kth(
                        Arrays.copyOfRange(arr1, mid1 + 1, n),
                        arr2,
                        n - (mid1 + 1),
                        m,
                        k - (mid1 + 1)
                );
            } else {
                return kth(
                        arr1,
                        Arrays.copyOfRange(arr2, mid2 + 1, m),
                        n,
                        m - (mid2 + 1),
                        k - (mid2 + 1)
                );
            }
        } else {
            if (arr1[mid1] < arr2[mid2]) {
                return kth(
                        arr1,
                        Arrays.copyOfRange(arr2, 0, mid2 + 1),
                        n,
                        mid2 + 1,
                        k
                );
            } else {
                return kth(
                        Arrays.copyOfRange(arr1, 0, mid1 + 1),
                        arr2,
                        mid1 + 1,
                        m,
                        k
                );
            }
        }
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
