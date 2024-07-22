// Implement Stack Using Queue;
//Leetcode Solution:

class MyStack {
    LinkedList <Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        int size = q.size();

        while(size > 1){
            q.add(q.remove());
            size--;
        }     
    }
    
    public int pop() {
      return q.remove();
    }
    
    public int top() {
       return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

// Implement Queue using Stack
class MyQueue {
    private Deque<Integer> stk1 = new ArrayDeque<>();
    private Deque<Integer> stk2 = new ArrayDeque<>();

    public MyQueue() {
    }

    public void push(int x) {
        stk1.push(x);
    }

    public int pop() {
        move();
        return stk2.pop();
    }

    public int peek() {
        move();
        return stk2.peek();
    }

    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }

    private void move() {
        while (stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
    }
}
