package src;


import java.util.Arrays;

public class Leetcode6 {
    public static void main(String[] args) {
        String test = "PAYPALISHIRING";
        String ans = convert(test, 4);
        System.out.println(ans);
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

//    Brute Force Method Implementation

//    public static String convert(String s, int numRows) {
//
//        int i = 0;
//        int ab = s.length() + (numRows - 1);
//        char[][] list = new char[numRows][ab];
//        StringBuilder result = new StringBuilder();
//        if (numRows > 1) {
//            for (int c = 0; c < ab; c++) {
//                for (int r = 0; r < numRows; r++) {
//                    if (i >= s.length())
//                        break;
//                    if (c % (numRows - 1) == 0) {
//                        list[r][c] = s.charAt(i);
//                        i++;
//                    } else if ((c + r) % (numRows - 1) == 0) {
//                        list[r][c] = s.charAt(i);
//                        i++;
//                    }
//                }
//            }
//        }
//        System.out.println("[");
//        for(int x = 0; x < list.length; x++){
//
//            System.out.print(" " + Arrays.toString(list[x]));
//
//            if(x < list.length - 1){
//                System.out.println(",");
//            }
//            else {
//                System.out.println();
//            }
//        }
//        System.out.print("]");
//        for (char[] chars : list) {
//            for (int y = 0; y < list[0].length; y++) {
//                if (chars[y] != '\u0000') {
//                    result.append(chars[y]);
//                }
//            }
//        }
//        System.out.println(result);
//        return numRows>1 ? result.toString() : s;
//    }

}

