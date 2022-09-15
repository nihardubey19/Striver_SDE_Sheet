    // Time Complexity : O(1) in push Ops, O(n) in pop Ops
    // Space Complexity : O(2n) for 2 Queue DS

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
