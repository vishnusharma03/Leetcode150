package src;

import java.util.Arrays;
import java.util.Collections;

public class Leetcode274 {
    public static void main(String[] args) {
        int[] citations = {0,2};
        int ans = hIndex(citations);
        System.out.println(ans);
    }

    public static int hIndex(int[] citations){
        int[] bucket = new int[citations.length+1];

        for (int i = 0; i < citations.length; i++) {
            if(citations[i] > citations.length){
                bucket[citations.length]++;
            }
            else
                bucket[citations[i]]++;
        }

        int count = 0;
        for (int i = bucket.length-1; i >= 0; i--) {
            count += bucket[i];
            if (count >= i){
                return i;
            }
        }
        return 0;
    }
}

//    public static int hIndex(int[] citations){
//        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
//        Arrays.sort(arr, Collections.reverseOrder());
//        int ans = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > i){
//                ans++;
//            }
//        }
//        return ans;
//    }
//}

//    public static int hIndex(int[] citations) {
//        if(citations.length==1 && citations[0]>0)
//            return 1;
//        int citNo = 0;
//        int maxEle = 0;
//        for (int i = 0; i < citations.length; i++) {
//            if(citations[i] > 0)
//                citNo++;
//        }
//        System.out.println("citNo "+ citNo);
//        for (int i = 0; i < citations.length; i++) {
//            if (citations[i] > maxEle && citations[i] <= citNo){
//                maxEle = citations[i];
//            }
//        }
//        return maxEle;
//    }
//}
