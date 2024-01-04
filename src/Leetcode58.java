package src;

public class Leetcode58 {
    public static void main(String[] args) {
        String name = "Vishnu Sharma";
        int ans = lengthOfLastWord(name);
        System.out.println(ans);
    }

    public static int lengthOfLastWord(String s) {
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) != ' ') {
                int j = i;
                while(j >= 0) {
                    if (s.charAt(j) == ' ') {
                        return i - j;
                    } else if (s.charAt(j) != 0 && j == 0) {
                        return i + 1;
                    }
                    j--;
                }
            }
        }
        return s.length();
    }
}
