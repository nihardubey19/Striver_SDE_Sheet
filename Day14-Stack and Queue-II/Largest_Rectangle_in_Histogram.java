    // Time Complexity : O(n^2)
    // Space Complexity : O(n)
    // Approach -> 1

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i<n; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i+1));
            }
        }
        return maxArea;
    }

// ----------------------------------------------------------------
  
    // using Stack
    // Time Complexity : O(n)
    // Space Complexity : O(3n), where we use 3 array and stack

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==1)
            return heights[0];
        
        Deque<Integer> st = new ArrayDeque<>();
        int[] LSR = new int[n];
        int[] LSL = new int[n];
        int[] width = new int[n];
        
        nearestSmallerRight(LSR, heights, st);
        st.clear();
        nearestSmallerLeft(LSL, heights, st);
        
        for(int i=0; i<n; i++){
            width[i] = (LSR[i] - LSL[i]) - 1;
        }
        
        int maxArea = 0;
        for(int i=0; i<n; i++){
            maxArea = Math.max(width[i] * heights[i], maxArea);
        }
        return maxArea;
    }
    
    private void nearestSmallerRight(int[] ans, int[] arr, Deque<Integer> st){
        int n = arr.length;
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                ans[i] = n;
            else
                ans[i] = st.peek();
            st.push(i);
        }
    } 
    
    private void nearestSmallerLeft(int[] ans, int[] arr, Deque<Integer> st){
        int n = arr.length;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(i);
        }  
    }
