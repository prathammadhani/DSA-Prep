//Problem Name: Implement Queue using Stacks
//Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/description/

class MyQueue {
    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();
    private int front;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!st1.isEmpty()) {
            st2.push(st1.peek());
            st1.pop();
        }
        st1.push(x);
        while(!st2.isEmpty()) {
            st1.push(st2.peek());
            st2.pop();
        }
    }
    
    public int pop() {
        if(!st1.isEmpty()) {
            front = st1.peek();
            st1.pop();
        }
        return front;
    }
    
    public int peek() {
        if(!st1.isEmpty()) {
            front = st1.peek();
        }
        return front;
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */