package src;

import java.util.Objects;
import java.util.Stack;

public class Leetcode150 {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}; // {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            if (Objects.equals(token, "+") || Objects.equals(token, "-") || Objects.equals(token, "*")
                    || Objects.equals(token, "/")){
                int x = stack.pop();
                int y = stack.pop();
                int ans = operate(x, y, token);
                stack.push(ans);
            }
            else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private static int operate(int x, int y, String token) {
        switch(token) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return y / x;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
