package src;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeContest {
    public static void main(String[] args) {
        String x = "mDVD";
        int ans = countKeyChanges(x);
        System.out.println(ans);
    }
    public static int countKeyChanges(String s) {
        char[] sOne = s.toLowerCase().toCharArray();
        List<Character> uniqueChars = new ArrayList<>();
        for (char c : sOne) {
            if (!uniqueChars.contains(c)) {
                uniqueChars.add(c);
            }
        }
        return uniqueChars.toArray().length;
    }
}
