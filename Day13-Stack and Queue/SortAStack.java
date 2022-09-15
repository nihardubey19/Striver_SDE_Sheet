    // Time Complexity : O(n)
    // Auxiallary Space : On)

    public static void sortStack(Stack<Integer> stack) {
        if(stack.size()==1)
            return;
        int val = stack.pop();
        sortStack(stack);
        helper(stack, val);
	}
    
    private static void helper(Stack<Integer> st, int val){
        if(st.isEmpty() || st.peek()<val){
            st.push(val);
            return;
        }
        int x = st.peek();
        st.pop();
        helper(st, val);
        st.push(x);
    }
