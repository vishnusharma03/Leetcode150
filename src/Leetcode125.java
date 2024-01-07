package src;

public class Leetcode125 {
    public static void main(String[] args) {
        String s = " ";
        boolean ans = isPalindrome(s);
        System.out.println(ans);
    }

    // A bit optimized solution than Brute Force
    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if (Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))) {
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                i--;
            } else if (!Character.isLetterOrDigit(s.charAt(i))){
                j++;
            }
            i++;
            j--;

        }

        return true;
    }
}


    //Brute Force Method
//    public static boolean isPalindrome(String s) {
//        StringBuilder ans = new StringBuilder();
//        s = s.toLowerCase();
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLetterOrDigit(s.charAt(i))){
//                ans.append(s.charAt(i));
//            }
//        }
//        s = ans.toString();
//        int j = s.length()-1;
//        int i = 0;
//        while(i < j){
//            if(s.charAt(i) != s.charAt(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//
//        return true;
//    }
//}
