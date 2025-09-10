import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;     // normal stack to store elements
    private Stack<Integer> minStack;  // helper stack to track minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element x onto stack
    public void push(int x) {
        stack.push(x);

        // If minStack is empty OR x <= current minimum
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Remove the element on top of stack
    public void pop() {
        int removed = stack.pop();

        // If removed element is the current min, pop it from minStack too
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get the top element
    public int top() {
        return stack.peek();
    }

    // Retrieve the minimum element in the stack
    public int getMin() {
        return minStack.peek();
    }
}
