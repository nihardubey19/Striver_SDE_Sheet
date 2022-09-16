// Time Complexity : O(1) Amortised
// Space Complexity : O(2n) for 2 stack

class MyQueue {
    Deque<Integer> s1, s2;
    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }else{
            return s2.pop();
        }
    }
    
    public int peek() {
        if(!s2.isEmpty())
            return s2.peek();
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s1.size() + s2.size()!=0 ? false : true;
    }
}
