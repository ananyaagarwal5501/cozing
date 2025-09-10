import java.util.Stack;

class MyQueue {
    // We use 2 stacks
    private Stack<Integer> inStack;   // for adding elements
    private Stack<Integer> outStack;  // for removing elements

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // 1. Push element x to the back of queue
    public void push(int x) {
        // Just push into inStack
        inStack.push(x);
    }

    // 2. Removes the element from the front of queue
    public int pop() {
        // Move elements to outStack if needed
        shiftStacks();
        // The front of the queue is now on top of outStack
        return outStack.pop();
    }

    // 3. Get the front element
    public int peek() {
        shiftStacks();
        return outStack.peek();
    }

    // 4. Returns true if queue is empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Helper function:
    // Moves elements from inStack → outStack if outStack is empty
    private void shiftStacks() {
        if (outStack.isEmpty()) {
            // Transfer all elements from inStack to outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
