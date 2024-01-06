package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode68 {
    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"}; //{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> ans = fullJustify(words, maxWidth);
        System.out.println(ans);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        builder.append(" ");
                    }
                }
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }
            } else {
                // Middle justified
                int spaces = (maxWidth - count) / diff;
                int extra = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        int spaceToAdd = spaces + ((i - index) < extra ? 1 : 0);
                        builder.append(" ".repeat(spaceToAdd + 1)); // +1 for the space already counted in 'count'
                    }
                }
            }
            result.add(builder.toString());
            index = last;
        }

        return result;
    }
}

    // Brute Force Method with Minor edge case errors like last line should be self justified
//    public static List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> ans = new ArrayList<>();
//
//
//        int LI = 0;
//        int WI = 0;
//        while (WI < words.length){
//            int WL = 0;
//            List<String> x = new ArrayList<>();
//            StringBuilder line = new StringBuilder();
//            while (WI < words.length && WL + words[WI].length() < maxWidth){
//
//                x.add(words[WI] + " ");
//
//                WL += words[WI].length() + 1;
//                WI++;
//
//            }
//            x.set(x.size()-1, x.get(x.size()-1).trim());
//            System.out.println(Arrays.toString(x.toArray()));
//            // Manipulating the line
////            line = line.deleteCharAt(line.length()-1);
////            int spaces = line.toString().split(" ").length - 1;
//            int spaces = x.size()-1;
//            int count = 0;
//            if (spaces > 0 && ((maxWidth-WL)/spaces) > 0){
//                count = ((maxWidth-WL+spaces+1)/spaces);
//            }
//
//            for (int i = 0; i < x.size(); i++) {
//                line.append(x.get(i));
//                if (count > 0) {
//                    line.append(" ".repeat(count - 1));
//                }else {
//                    line.append(" ".repeat(count));
//                }
//            }
//
//            int dI = line.length() - 1;
//            while (line.length() > maxWidth){
//                line.deleteCharAt(dI);
//                dI--;
//            }
//            while(line.length() < maxWidth){
//                line.append(" ");
//            }
//            System.out.println(line.length());
//            ans.add(line.toString());
//            LI++;
//        }
////        for (int i = 0; i < ans.size(); i++) {
////            ans.set(i, ans.get(i).trim());
////            int spaces = ans.get(i).split(" ").length - 1;
////            int length = 0;
////            for (int j = 0; j < spaces + 1; j++) {
////                length += ans.get(i).split(" ")[j].length();
////            }
////            for (int j = 0; j < ans.get(i).length(); j++) {
////
////            }
////        }
//        return ans;
//    }
//}

    //public static List<String> fullJustify(String[] words, int maxWidth) {
    //    List<String> ans = new ArrayList<>();
    //
    //    int LI = 0;
    //    int S = 0;
    //    int WI = 0;
    //    while (WI < words.length){
    //        StringBuilder line = new StringBuilder();
    //        while (WI < words.length && (line.length() + words[WI].length()) < maxWidth){
    //            line.append(words[WI]).append(" ");
    //            S = 1;
    //            WI++;
    //        }
    //        ans.add(line.toString());
    //        LI++;
    //    }
    //    return ans;
    //}
