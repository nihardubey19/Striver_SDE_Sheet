    // Time Complexity : O(1) in push Ops, O(n) in pop Ops
    // Space Complexity : O(2n) for 2 Queue DS
    // Using 2 queues 

    Queue<Integer> q1, q2;
    int top;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        top = x;
    }
    
    public int pop() {
        while(q1.size()>1){
            top = q1.peek();
            q2.add(q1.poll());
        }
        int peek = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return peek;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty() ? true : false;
    }

// -------------------------------------------------

    // Time Complexity  : O(n)
    // Space Complexity : O(n)
   
class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        for(int i=0; i<q.size()-1; i++)
            q.add(q.poll());
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
