import java.util.Arrays;

public class Leetcode26 {
    public static void main(String[] args) {
        int[] nums = {0,1,2};
        int x = removeDuplicates(nums);
        System.out.println(x);
    }

    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int j = 0; j < nums.length-1; j++) {
            if(nums[j] != nums[j+1]) {
                nums[k] = nums[j+1];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }


//    public static int removeDuplicates(int[] nums) {
//        int i = 0;
//        int x = 0;
//        int l = nums.length-1;
//        while(i< nums.length-1 && l > 1){
//            x = 1;
//            if(nums[i] == nums[i+1]){
//                int temp = nums[i];
//                int j = i;
//                while(j< nums.length-1){
//                    nums[j] = nums[j+1];
//                    j++;
//                }
//                nums[nums.length-1] = temp;
//                l--;
//            }
//            else i++;
//        }
//        System.out.println(Arrays.toString(nums));
//        for (int j = 0; j < nums.length-1; j++) {
//            if (nums[j] > nums[j+1]) {
//                return j + 1;
//            }
//        }
//        if (x==0){
//            return nums.length;
//        }
//
//        return 1;
//    }

//    public static int removeDuplicates(int[] nums){
//         ArrayList<Integer> arr = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!arr.contains(nums[i])){
//                arr.add(nums[i]);
//            }
//        }
//        int k = arr.size();
//        int i=0;
//        while(arr.get(k-1)!=nums[k-1]){
//            if (nums[i] == nums[i + 1]) {
//                int temp = nums[i];
//                while (i < nums.length - 1) {
//                    nums[i] = nums[i + 1];
//                    i++;
//                }
//                nums[nums.length - 1] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        return arr.size();
//    }
}
