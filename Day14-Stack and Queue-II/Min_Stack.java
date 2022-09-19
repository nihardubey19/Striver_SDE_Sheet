    // Time Complexity : O(1) for each opertion
    // Space Complexity : O(N)+O(N) for stack and Pair class Object

class MinStack {
    Deque<Pair> st;
    int min = 0;
    public MinStack() {
        st = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
            min = val;
        else
            min = Math.min(st.peek().min, val);
        st.push(new Pair(val, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
    
    static class Pair{
        int val, min;
        public Pair(int _val, int _min){
            val = _val;
            min = _min;
        }
    }
}
