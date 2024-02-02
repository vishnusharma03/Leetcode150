package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Leetcode12 {
    public static void main(String[] args) {
        int num = 3475;
        System.out.println(intToRoman(num));
//        System.out.println(closestTo(3));
    }

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        if (num <= 0 || num > 3999) {
            throw new IllegalArgumentException(num + " is not in range (0,3999]");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(romanLiterals[i]);
            }
        }

        return sb.toString();
    }
}

    // Error 102
//    private static int intToRoman(int num) {
//        HashMap<Integer, Character> map = new HashMap<>();
//        map.put(1, 'I');
//        map.put(5, 'V');
//        map.put(10, 'X');
//        map.put(50, 'L');
//        map.put(100, 'C');
//        map.put(500, 'D');
//        map.put(1000, 'M');
//
//        int placeValue = (int) Math.pow(10, (String.valueOf(num).length()-1));
//        int[] nums = new int[String.valueOf(placeValue).length()];
//        int index = 0;
//
//        while(placeValue > 0){
//            int digit = (num / placeValue) % 10;
//            nums[index] = digit * placeValue;
//            placeValue = placeValue / 10;
//            index++;
//        }
//
//        return 0;
//    }
//
//}


    // Error 101
//    static HashMap<Integer, Character> map;
//
//    public static String intToRoman(int num) {
//        map = new HashMap<>();
//        map.put(1, 'I');
//        map.put(5, 'V');
//        map.put(10, 'X');
//        map.put(50, 'L');
//        map.put(100, 'C');
//        map.put(500, 'D');
//        map.put(1000, 'M');
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        int i = 1;
//        while(num>0){
//            int rem = num%10;
//            int sOne = rem*i;
//            int fi = closestTo(sOne);
//            while(sOne-fi!=0) {
//                fi = closestTo(sOne);
//                if (fi > sOne) {
//                    list.add(fi);
//                    sOne = sOne - fi;
//                }else {
//                    int fi2 = closestTo(sOne-fi);
//                    list.add(fi2);
//                    list.add(fi);
//                }
//            }
//            num = num/10;
//            i *= 10;
//        }
//        System.out.println(list);
//
//
//
//        return "X";
//    }
//
//    private static int closestTo(int num){
//        int c = String.valueOf(num).length();
//        switch (c){
//            case 1:
//                if (IntStream.rangeClosed(1, 4).anyMatch(x -> x == num))
//                    return 1;
//                else if (IntStream.rangeClosed(4, 9).anyMatch(x -> x == num))
//                    return 5;
//                else if (IntStream.rangeClosed(9, 11).anyMatch(x -> x == num))
//                    return 10;
//            case 2:
//                if (IntStream.rangeClosed(11, 31).anyMatch(x -> x == num))
//                    return 10;
//                else if (IntStream.rangeClosed(31, 81).anyMatch(x -> x == num))
//                    return 50;
//                else if (IntStream.rangeClosed(81, 101).anyMatch(x -> x == num))
//                    return 100;
//            case 3:
//                if (IntStream.rangeClosed(101, 301).anyMatch(x -> x == num))
//                    return 100;
//                else if (IntStream.rangeClosed(301, 801).anyMatch(x -> x == num))
//                    return 500;
//                else if (IntStream.rangeClosed(801, 1001).anyMatch(x -> x == num))
//                    return 1000;
//        }
//        return 0;
//    }
//}
