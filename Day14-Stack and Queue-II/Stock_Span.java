    // Time Complexity : O(n)
    // Space Complexity : O(2n) for stack and Pair class

    Deque<Pair> st;
    int idx=0;
    public StockSpanner() {
        st = new ArrayDeque<>();
    }
        
    public int next(int price) {
        int ans = -1;
        while(!st.isEmpty() && st.peek().price<=price)
            st.pop();
        if(st.isEmpty())
            ans = idx-ans;
        else if(!st.isEmpty() && st.peek().price>price)
            ans = idx - st.peek().idx;
        st.push(new Pair(price,idx++));
        return ans;   
    }
    
    static class Pair{
        int price;
        int idx;
        public Pair(int _price, int _idx){
            price = _price;
            idx = _idx;
        }
    }
