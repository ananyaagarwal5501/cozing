class MyStack 
{
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) 
    {
        //The trick for this problem is:
        //1. Insert x.
        //2. Rotate the existing elements behind it, so x comes to the front.
        queue.add(x); //1.

     int size= queue.size();

     for(int i=0; i<size-1; i++)//2. rotate (size-1) elements behind it
     {
        queue.add(queue.remove()); 
     }   
    }
    
    public int pop() 
    {
        return queue.remove();
        
    }
    
    public int top() 
    {
        return queue.peek();

        
    }
    
    public boolean empty() 
    {
     return queue.isEmpty();   
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */