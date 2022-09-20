    // Time Complexity : O(n)
    // Space Complexity : O(k) // k->number of windows

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int i=0, j=0, idx=0;
        
        while(j<n){
            while(!dq.isEmpty() && nums[j]>dq.peekLast()){
                dq.pollLast();
            }
            dq.add(nums[j]);
            
            if(j-i+1 == k){
                ans[idx++] = dq.peek();        
                if(nums[i] == dq.peek()){
                    dq.poll();
                }
                i++;
            }
            j++;
        }
        return ans;
    }

// -----------------------------------------------------------

    // Time Complexity : O(n^2)
    // Space Complexity : O(1)

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx=0;
        int[] ans = new int[n-k+1];
        for(int i=0; i<n-k+1; i++){
            int max = 0;
            for(int j=i; j<i+k; j++){
                max = Math.max(nums[j],max);
            }
            ans[idx++] = max;
        }
        return ans;
    }
