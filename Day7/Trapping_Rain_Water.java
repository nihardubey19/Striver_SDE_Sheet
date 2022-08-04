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

// --------------------------------------------------------------------
    
    // using Time complexity : 
    // O(n) -> becoz we are using 2 pointers only 
    // Space complexity : 
    // O(1) -> becoz we are not using any extra solutions 
    public int trap(int[] height) {
        int n = height.length;
        int left=0, right=n-1;
        int leftMax = 0, rightMax = 0, ans=0;
        
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax){
                    leftMax = height[left];
                }else{
                    ans+=leftMax - height[left];
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    ans+=rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
