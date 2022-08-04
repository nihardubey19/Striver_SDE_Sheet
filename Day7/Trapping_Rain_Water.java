// using Time complexity : 
    // O(3 * n) 
    // Space complexity : 
    // O(n) + O(n) for prefix and suffix array 
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        prefix[0] = height[0];
        for(int i=1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }
        
        suffix[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }
        int totalWater = 0;
        
        for(int i=0; i<n; i++){
            totalWater+=(Math.min(prefix[i], suffix[i]) - height[i]);
        }
        return totalWater;
    }
