package src;

import java.util.Objects;
import java.util.Stack;

public class Leetcode224 {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)"; //  " 2-1 + 2 "; // "1 + 1"; //
        System.out.println(calculate(s));
    }

// Edge case issues : Fixing it
    public static int calculate(String s) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch==')'){
                while (true){
                    char op = charStack.pop();
                    if (op=='(') {
                        break;
                    }
                    int x = intStack.pop();
                    int y  = intStack.pop();
                    int ans = compute(x, y, op);
                    intStack.push(ans);
                }
            }

            if (ch!=' '){
                if (ch=='+' || ch=='-' || ch=='('){ // || ch==')'
                    charStack.push(ch);
                }
                else if (ch!=')') {
                    // Not implementing for double digit values rn.
                    intStack.push(ch - '0');
                }
            }
        }
        // No parenthesis behaviour.
//        intStack

        while (!charStack.isEmpty()){
            char op = charStack.pop();
            int one = intStack.pop();
            int two = 0;
            if (!intStack.isEmpty())
                two = intStack.pop();

            int ans = compute(one, two, op);
            intStack.push(ans);
        }
        return intStack.pop();
    }

    private static int compute(int x, int y, Character op) {

        return switch (op) {
            case '+' -> x + y;
            case '-' -> y - x;
            case '*' -> x * y;
            case '/' -> y / x;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }
}




// Even GenAI can't solve it
//    public static int calculate(String s) {
//        Stack<Character> charStack = new Stack<>();
//        Stack<Integer> intStack = new Stack<>();
//
//        StringBuilder numBuilder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (Character.isDigit(ch)) {
//                numBuilder.append(ch);
//            } else {
//                // Process operand or operator when a non-digit character is encountered
//                if (!numBuilder.isEmpty()) {
//                    int num = Integer.parseInt(numBuilder.toString());
//                    intStack.push(num);
//                    numBuilder.setLength(0); // Reset StringBuilder for the next number
//                }
//
//                if (ch == '(') {
//                    charStack.push(ch);
//                } else if (ch == ')') {
//                    while (!charStack.isEmpty() && charStack.peek() != '(') {
//                        char op = charStack.pop();
//                        int x = intStack.pop();
//                        int y = intStack.pop();
//                        int ans = compute(x, y, op);
//                        intStack.push(ans);
//                    }
//                    charStack.pop(); // Remove the opening parenthesis
//                } else if (ch == '+' || ch == '-') {
//                    while (!charStack.isEmpty() && (charStack.peek() == '*' || charStack.peek() == '/')) {
//                        char op = charStack.pop();
//                        int x = intStack.pop();
//                        int y = intStack.pop();
//                        int ans = compute(x, y, op);
//                        intStack.push(ans);
//                    }
//                    charStack.push(ch);
//                } else if (ch == '*' || ch == '/') {
//                    charStack.push(ch);
//                } else {
//                    throw new IllegalArgumentException("Invalid character: " + ch);
//                }
//            }
//        }
//
//        // Process remaining operators after processing the entire string
//        while (!charStack.isEmpty()) {
//            char op = charStack.pop();
//            int one = intStack.pop();
//            int two = 0;
//            if (!intStack.isEmpty()) {
//                two = intStack.pop();
//            }
//            int ans = compute(one, two, op);
//            intStack.push(ans);
//        }
//
//        if (intStack.size() != 1) {
//            throw new IllegalArgumentException("Invalid expression format");
//        }
//
//        return intStack.pop();
//    }
//
//    private static int compute(int x, int y, Character op) {
//
//        return switch (op) {
//            case '+' -> x + y;
//            case '-' -> y - x;
//            case '*' -> x * y;
//            case '/' -> y / x;
//            default -> throw new IllegalArgumentException("Invalid operator");
//        };
//    }
//}




    // Iteration + Error
//    public static int calculate(String s) {
//        Stack<Character> stack = new Stack<>();
//        int ans = 0;
//        for(Character ch : s.toCharArray()){
//            if (Objects.equals(ch, ')')){
//                Character x = ' ';
//                Character y = ' ';
//
//                while (!Objects.equals('(', x) || !Objects.equals('(', y)){
//                    x = stack.pop();
//                    Character op = stack.pop();
//                    if (Objects.equals(op, '(')){
//                        break;
//                    }
//                    y = stack.pop();
//                    if (!Objects.equals('(', x) || !Objects.equals('(', y)){
//                        ans = operate(x, y, op);
//                        stack.push( Character.forDigit(ans, 10));
//                    }
//                }
////                stack.push(y);
//                stack.push(Character.forDigit(ans, 10));
//            }
//            stack.push(ch);
//        }
//        return ans;
//    }
//
//    private static int operate(Character a, Character b, Character op) {
//        int x = a - '0';
//        int y = b - '0';
//
//        return switch (op) {
//            case '+' -> x + y;
//            case '-' -> y - x;
//            case '*' -> x * y;
//            case '/' -> y / x;
//            default -> throw new IllegalArgumentException("Invalid operator");
//        };
//    }
//}
