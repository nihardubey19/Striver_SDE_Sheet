    // using Stack 
    // Time Complexity : O(n+n)
    // Space Complexity : O(n)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=n*2-1; i>=0; i--){
            while(!st.isEmpty() && nums[i%n]>=st.peek())
                st.pop();
            if(!st.isEmpty())
                ans[i%n] = st.peek();
            st.push(nums[i%n]);
        }
        return ans;
    }
