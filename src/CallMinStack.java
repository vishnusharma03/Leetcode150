package src;

public class CallMinStack {
    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());    // returns 2147483647
        minStack.pop();
        System.out.println(minStack.getMin()); // returns 2147483646
        minStack.pop();
        System.out.println(minStack.getMin()); // returns 2147483646
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());    // returns 2147483647
        System.out.println(minStack.getMin()); // returns 2147483647
        minStack.push(-2147483648);
        System.out.println(minStack.top());    // returns -2147483648
        System.out.println(minStack.getMin()); // returns -2147483648
        minStack.pop();
        System.out.println(minStack.getMin()); // returns 2147483647
    }
}
